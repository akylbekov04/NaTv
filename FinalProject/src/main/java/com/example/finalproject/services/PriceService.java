package com.example.finalproject.services;

import com.example.finalproject.models.dto.ChannelDto;
import com.example.finalproject.models.dto.PriceDto;
import com.example.finalproject.models.request.PriceRequest;
import java.util.Date;
import java.util.List;


public interface PriceService extends BaseService<PriceDto>{
    PriceDto save(ChannelDto dto, Double price);


    Double getActualPrice(Long channelId, List<Date> days, int textLen);

    PriceDto save(PriceRequest request);
}
