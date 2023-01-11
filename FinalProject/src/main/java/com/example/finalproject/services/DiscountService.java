package com.example.finalproject.services;

import com.example.finalproject.models.dto.DiscountDto;
import com.example.finalproject.models.request.DiscountRequest;


public interface DiscountService extends BaseService<DiscountDto>{
    double getDiscountNegativePercent(Long channelId, int dayCount);

    DiscountDto save(DiscountRequest request);
}
