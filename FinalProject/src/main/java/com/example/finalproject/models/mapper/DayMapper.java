package com.example.finalproject.models.mapper;

import com.example.finalproject.models.dto.DayDto;
import com.example.finalproject.models.entity.Day;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DayMapper extends BaseMapper<Day, DayDto>{
    DayMapper INSTANCE= Mappers.getMapper(DayMapper.class);
}
