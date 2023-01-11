package com.example.finalproject.services.Impl;

import com.example.finalproject.models.dto.DiscountDto;
import com.example.finalproject.models.entity.Discount;
import com.example.finalproject.models.info.ActualDiscount;
import com.example.finalproject.models.mapper.DiscountMapper;
import com.example.finalproject.models.request.DiscountRequest;
import com.example.finalproject.repository.DiscountRepository;
import com.example.finalproject.services.DiscountService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import com.example.finalproject.models.dto.ChannelDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscountServiceImpl extends BaseServiceImpl<Discount, DiscountDto> implements DiscountService {

    private final DiscountRepository rep;

    private DiscountServiceImpl(DiscountRepository rep) {
        super(rep, DiscountMapper.INSTANCE);
        this.rep = rep;
    }


    @Override
    public double getDiscountNegativePercent(Long channelId, int dayCount) {
        ActualDiscount actualDiscount = rep.getActualDiscount(channelId, dayCount);
        if (actualDiscount == null)
            return 1;
        return (100 - actualDiscount.getPercent()) / 100;
    }

    @Override
    public DiscountDto save(DiscountRequest request) {
        return save(
                DiscountDto.builder()
                        .channel(ChannelDto.builder()
                                .id(request.getChannelId())
                                .build()
                        )
                        .percent(request.getPercent())
                        .minDay(request.getMinDay())
                        .startDate(request.getStartDate())
                        .endDate(request.getEndDate())
                        .build()
        );
    }


}
