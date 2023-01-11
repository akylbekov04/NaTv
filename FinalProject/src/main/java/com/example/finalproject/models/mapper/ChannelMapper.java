package com.example.finalproject.models.mapper;

import com.example.finalproject.models.dto.ChannelDto;
import com.example.finalproject.models.entity.Channel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChannelMapper extends BaseMapper<Channel, ChannelDto> {
    ChannelMapper INSTANCE= Mappers.getMapper(ChannelMapper.class);
}
