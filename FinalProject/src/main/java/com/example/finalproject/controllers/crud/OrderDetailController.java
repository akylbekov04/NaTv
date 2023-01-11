package com.example.finalproject.controllers.crud;

import com.example.finalproject.configs.Swagger;
import com.example.finalproject.models.dto.OrderDetailDto;
import com.example.finalproject.services.BaseService;
import com.example.finalproject.services.OrderDetailService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orderDetail")
@Api(Swagger.ORDER_DETAIL)
public class OrderDetailController extends BaseController<OrderDetailDto>{
    @Autowired
    OrderDetailService orderDetailService;

    public OrderDetailController(BaseService<OrderDetailDto> service, OrderDetailService orderDetailService) {
        super(service);
        this.orderDetailService = orderDetailService;
    }
}
