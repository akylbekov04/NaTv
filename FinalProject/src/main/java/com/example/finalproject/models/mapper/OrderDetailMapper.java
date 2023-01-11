package com.example.finalproject.models.mapper;

import com.example.finalproject.models.dto.OrderDetailDto;
import com.example.finalproject.models.entity.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail, OrderDetailDto>{
    OrderDetailMapper INSTANCE= Mappers.getMapper(OrderDetailMapper.class);
}
