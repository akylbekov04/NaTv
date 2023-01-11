package com.example.finalproject.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChannelPriceResponse {
    @JsonProperty("channel_id")
    Long id;
    Double price;
    @JsonProperty("price_with_discount")
    Double discountPrice;
}
