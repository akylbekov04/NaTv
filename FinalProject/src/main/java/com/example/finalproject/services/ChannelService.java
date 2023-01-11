package com.example.finalproject.services;

import com.example.finalproject.models.dto.ChannelDto;
import com.example.finalproject.models.response.GetChannelResponse;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ChannelService extends BaseService<ChannelDto>{
    List<GetChannelResponse> getChannels(Pageable pageable);

    ChannelDto save(String name, int orderNum, MultipartFile photo, Double price);
}
