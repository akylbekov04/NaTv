package com.example.finalproject.models.mapper;

import com.example.finalproject.models.dto.PriceDto;
import com.example.finalproject.models.entity.Price;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceMapper extends BaseMapper<Price, PriceDto>{
    PriceMapper INSTANCE= Mappers.getMapper(PriceMapper.class);
}
