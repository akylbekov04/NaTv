package com.example.finalproject.controllers.crud;

import com.example.finalproject.configs.Swagger;
import com.example.finalproject.models.dto.PriceDto;
import com.example.finalproject.services.BaseService;
import com.example.finalproject.services.PriceService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/price")
@Api(Swagger.PRICE)
public class PriceController extends BaseController<PriceDto> {
    @Autowired
    PriceService priceService;

    public PriceController(BaseService<PriceDto> service, PriceService priceService) {
        super(service);
        this.priceService = priceService;
    }
}
