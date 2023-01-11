package com.example.finalproject.controllers.crud;

import com.example.finalproject.configs.Swagger;
import com.example.finalproject.models.dto.DayDto;
import com.example.finalproject.services.BaseService;
import com.example.finalproject.services.DayService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/day")
@Api(tags= Swagger.DAYS)
public class DayController extends BaseController<DayDto> {
    @Autowired
    DayService dayService;

    public DayController(BaseService<DayDto> service, DayService dayService) {
        super(service);
        this.dayService = dayService;
    }
}
