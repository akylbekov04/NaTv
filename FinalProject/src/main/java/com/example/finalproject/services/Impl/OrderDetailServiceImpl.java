package com.example.finalproject.services.Impl;

import com.example.finalproject.models.dto.OrderDetailDto;
import com.example.finalproject.models.dto.OrderDto;
import com.example.finalproject.models.entity.Order;
import com.example.finalproject.models.entity.OrderDetail;
import com.example.finalproject.models.mapper.BaseMapper;
import com.example.finalproject.models.mapper.OrderDetailMapper;
import com.example.finalproject.models.mapper.OrderMapper;
import com.example.finalproject.models.request.ChannelDaysRequest;
import com.example.finalproject.models.request.OrderRequest;
import com.example.finalproject.models.request.TextAndChannelWithDays;
import com.example.finalproject.models.response.ChannelPriceResponse;
import com.example.finalproject.models.response.TotalPriceChannels;
import com.example.finalproject.repository.OrderDetailRepository;
import com.example.finalproject.services.*;
import com.example.finalproject.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetail, OrderDetailDto> implements OrderDetailService {

    private final PriceService priceService;
    private final DiscountService discountService;
    private final ChannelService channelService;

    private final OrderService orderService;
    private final DayService dayService;

    @Autowired
    public OrderDetailServiceImpl(BaseRepository<OrderDetail, Long> repository, PriceService priceService, DiscountService discountService, ChannelService channelService, OrderService orderService, DayService dayService) {
        super(repository, OrderDetailMapper.INSTANCE);
        this.priceService = priceService;
        this.discountService = discountService;
        this.channelService = channelService;
        this.orderService = orderService;
        this.dayService = dayService;
    }

    @Override
    public TotalPriceChannels save(OrderRequest request) {
        TotalPriceChannels totalPriceAndChannels = getPricesByChannelsAndDays(
                TextAndChannelWithDays
                        .builder()
                        .text(request.getText())
                        .channelIdAndDaysList(request.getChannels())
                        .build()
        );
        OrderDto orderDto = orderService.save(
                OrderDto
                        .builder()
                        .email(request.getEmail())
                        .phone(request.getPhone())
                        .name(request.getName())
                        .totalPrice(totalPriceAndChannels.getTotalPriceWithDiscount())
                        .text(request.getText())
                        .build()
        );


        Map<Long, Double> priceMap = new HashMap<>();
        for (var i : totalPriceAndChannels.getChannelPriceResponseList()) {
            priceMap.put(i.getId(), i.getDiscountPrice());
        }
        for (var item : request.getChannels()) {
            OrderDetailDto orderDetailDto = this.save(
                    OrderDetailDto
                            .builder()
                            .orders(orderDto)
                            .price(priceMap.get(item.getId()))
                            .channel((ChannelService) channelService.findById(item.getId()))
                            .build()
            );
            dayService.save(orderDetailDto, item.getDays());

        }


        return totalPriceAndChannels;
    }


    @Override
    public TotalPriceChannels getPricesByChannelsAndDays(TextAndChannelWithDays request) {
        Double price = 0d;
        Double priceDiscount = 0d;
        List<ChannelPriceResponse> list = new ArrayList<>();
        for (var item : request.getChannelIdAndDaysList()) {
            ChannelPriceResponse priceResponse = getPriceByOnlyChannel(item, request.getText());
            price += priceResponse.getPrice();
            priceDiscount += priceResponse.getDiscountPrice();
            list.add(priceResponse);
        }

        return TotalPriceChannels
                .builder()
                .totalPrice(price)
                .channelPriceResponseList(list)
                .totalPriceWithDiscount(priceDiscount)
                .build();
    }

    @Override
    public ChannelPriceResponse getPriceByOnlyChannel(ChannelDaysRequest request, String text) {
        int textLen = text.length() - StringUtils.countOccurrencesOf(text, " ");
        double price = priceService.getActualPrice(request.getId(), request.getDays(), textLen);
        return ChannelPriceResponse.builder()
                .id(request.getId())
                .price(price)
                .discountPrice(
                        price * discountService
                                .getDiscountNegativePercent(
                                        request.getId(),
                                        request.getDays().size()
                                )
                )
                .build();
    }
}
