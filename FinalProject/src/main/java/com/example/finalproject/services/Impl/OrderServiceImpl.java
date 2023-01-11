package com.example.finalproject.services.Impl;

import com.example.finalproject.models.dto.OrderDto;
import com.example.finalproject.models.entity.Order;
import com.example.finalproject.models.mapper.OrderMapper;
import com.example.finalproject.repository.BaseRepository;
import com.example.finalproject.repository.OrderRepository;
import com.example.finalproject.services.OrderService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderServiceImpl extends BaseServiceImpl<Order, OrderDto> implements OrderService {
    private OrderServiceImpl(OrderRepository rep) {
        super(rep, OrderMapper.INSTANCE);
    }
}
