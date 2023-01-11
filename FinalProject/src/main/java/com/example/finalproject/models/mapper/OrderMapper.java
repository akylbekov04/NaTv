package com.example.finalproject.models.mapper;

import com.example.finalproject.models.dto.OrderDto;
import com.example.finalproject.models.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface OrderMapper extends BaseMapper<Order, OrderDto>{
    OrderMapper INSTANCE= Mappers.getMapper(OrderMapper.class);
}
