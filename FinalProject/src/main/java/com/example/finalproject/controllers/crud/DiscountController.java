package com.example.finalproject.controllers.crud;

import com.example.finalproject.configs.Swagger;
import com.example.finalproject.models.dto.DiscountDto;
import com.example.finalproject.services.BaseService;
import com.example.finalproject.services.DiscountService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/discount")
@Api(Swagger.DISCOUNT)
public class DiscountController extends BaseController<DiscountDto>{
    @Autowired
    DiscountService discountService;

    public DiscountController(BaseService<DiscountDto> service, DiscountService discountService) {
        super(service);
        this.discountService = discountService;
    }
}
