package com.example.finalproject.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TotalPriceChannels {
    @JsonProperty("total_price")
    Double totalPrice;
    @JsonProperty("total_price_with_discount")
    Double totalPriceWithDiscount;
    @JsonProperty("channels")
    List<ChannelPriceResponse> channelPriceResponseList;
}
