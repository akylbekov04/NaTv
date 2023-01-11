package com.example.finalproject.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceRequest {
    @JsonProperty("channel_id")
    Long channelId;
    Double price;
    @JsonProperty("end_date")
    Date endDate;
    @JsonProperty("start_date")
    Date startDate;

}
