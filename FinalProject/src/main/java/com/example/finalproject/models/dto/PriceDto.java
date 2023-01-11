package com.example.finalproject.models.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link com.example.finalproject.models.entity.Price} entity
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PriceDto implements Serializable {
    private  Long id;
    private  Boolean active;
    private  Date startDate;
    private  Date endDate;
    private  Double price;
    private ChannelDto channels;


}