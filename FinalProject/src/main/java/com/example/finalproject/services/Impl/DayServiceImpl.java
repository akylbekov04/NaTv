package com.example.finalproject.services.Impl;

import com.example.finalproject.models.dto.DayDto;
import com.example.finalproject.models.dto.OrderDetailDto;
import com.example.finalproject.models.entity.Day;
import com.example.finalproject.models.mapper.DayMapper;
import com.example.finalproject.repository.DayRepository;
import com.example.finalproject.services.DayService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DayServiceImpl extends BaseServiceImpl<Day, DayDto> implements DayService {
    private DayServiceImpl(DayRepository rep) {

        super(rep, DayMapper.INSTANCE);
    }

    @Override
    public void save(OrderDetailDto orderDetailDto, List<Date> days) {
        for (var day:days){
            DayDto dto=new DayDto();
            dto.setOrderDetails(orderDetailDto);
            dto.setDay(day);
            this.save(dto);
        }
    }
}

