package com.example.finalproject.models.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
public class ChannelDaysRequest {
    @JsonProperty("channel_id")
    Long id;
    @JsonFormat(pattern = "YYYY.MM.DD")
    @ApiModelProperty(example = "[\"2023.01.01\"]")

    List<Date> days;
}
