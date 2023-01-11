package com.example.finalproject.controllers.defaultControllers;

import com.example.finalproject.configs.Swagger;
import com.example.finalproject.models.request.OrderRequest;
import com.example.finalproject.models.request.TextAndChannelWithDays;
import com.example.finalproject.models.response.TotalPriceChannels;
import com.example.finalproject.services.OrderDetailService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
@Api(tags = Swagger.ORDERS)
public class OrderContr {
    OrderDetailService orderDetailService;

    public OrderContr(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @PostMapping("save/orders")
//    @ApiOperation("метод для получения данных")
    ResponseEntity<?> saveOrder(@RequestBody OrderRequest request){

        return ResponseEntity.ok(orderDetailService.save(request));//TODO Нужно уточнить
    }



    @PostMapping ("order/price")
    ResponseEntity<TotalPriceChannels> getOrderPrice(@RequestBody TextAndChannelWithDays request){
        return ResponseEntity.ok(orderDetailService.getPricesByChannelsAndDays(request));
    }



}
