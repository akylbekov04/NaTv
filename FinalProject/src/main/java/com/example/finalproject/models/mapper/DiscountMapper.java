package com.example.finalproject.models.mapper;

import com.example.finalproject.models.dto.DiscountDto;
import com.example.finalproject.models.entity.Discount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DiscountMapper extends BaseMapper<Discount, DiscountDto>{
    DiscountMapper INSTANCE= Mappers.getMapper(DiscountMapper.class);
}
