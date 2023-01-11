package com.example.finalproject.models.dto;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class DiscountDto implements Serializable {
    private  Long id;
    private  Boolean active;
    private ChannelDto channel;
    private  Double percent;
    private  Date startDate;
    private  Date endDate;
    private  int minDay;
}