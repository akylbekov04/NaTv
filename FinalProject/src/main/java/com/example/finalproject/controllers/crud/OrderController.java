package com.example.finalproject.controllers.crud;

import com.example.finalproject.configs.Swagger;
import com.example.finalproject.models.dto.OrderDto;
import com.example.finalproject.services.BaseService;
import com.example.finalproject.services.OrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/order")
@Api(Swagger.ORDERS)
public class OrderController extends BaseController<OrderDto> {
    @Autowired
    OrderService orderService;

    public OrderController(BaseService<OrderDto> service, OrderService orderService) {
        super(service);
        this.orderService = orderService;
    }
}
