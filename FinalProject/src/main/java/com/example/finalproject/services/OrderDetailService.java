package com.example.finalproject.services;

import com.example.finalproject.models.dto.OrderDetailDto;
import com.example.finalproject.models.request.ChannelDaysRequest;
import com.example.finalproject.models.request.OrderRequest;
import com.example.finalproject.models.request.TextAndChannelWithDays;
import com.example.finalproject.models.response.ChannelPriceResponse;
import com.example.finalproject.models.response.TotalPriceChannels;


public interface OrderDetailService extends BaseService<OrderDetailDto>{
    TotalPriceChannels getPricesByChannelsAndDays(TextAndChannelWithDays request);
    ChannelPriceResponse getPriceByOnlyChannel(ChannelDaysRequest request, String text);

    TotalPriceChannels save(OrderRequest order);
}
