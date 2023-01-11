package com.example.finalproject.controllers.crud;
import com.example.finalproject.configs.Swagger;
import com.example.finalproject.models.dto.ChannelDto;
import com.example.finalproject.services.ChannelService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/crud/channel")
@Api(tags = Swagger.CHANNEL)
public class ChannelsController extends BaseController<ChannelDto>{
    private final ChannelService service;

    public ChannelsController(ChannelService service) {
        super(service);
        this.service = service;
    }
}
