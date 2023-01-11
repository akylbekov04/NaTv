package com.example.finalproject.services;

import com.example.finalproject.models.dto.DayDto;
import com.example.finalproject.models.dto.OrderDetailDto;

import java.util.Date;
import java.util.List;


public interface DayService extends BaseService<DayDto>{
    void save(OrderDetailDto orderDetailDto, List<Date> days);

}
