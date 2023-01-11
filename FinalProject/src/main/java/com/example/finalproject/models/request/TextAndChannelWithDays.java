package com.example.finalproject.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TextAndChannelWithDays {
    String text;
    @JsonProperty("channels")
    List<ChannelDaysRequest> channelIdAndDaysList;

}
