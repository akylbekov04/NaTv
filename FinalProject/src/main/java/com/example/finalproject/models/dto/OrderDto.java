package com.example.finalproject.models.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link com.example.finalproject.models.entity.Order} entity
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class OrderDto implements Serializable {
    private  Long id;
    private  Boolean active;
    private  String text;
    private  String name;
    private  String phone;
    private  String email;
    private  Date addDate;
    private  Date editDate;
    private  Boolean status;
    private double totalPrice;
}