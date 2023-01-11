package com.example.finalproject.models.dto;

import com.example.finalproject.services.ChannelService;
import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.finalproject.models.entity.OrderDetail} entity
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class OrderDetailDto implements Serializable {
    private  Long id;
    private  Boolean active;
    private  Double price;
    private OrderDto orders;
    private ChannelService channel;
}