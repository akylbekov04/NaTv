package com.example.finalproject.models.dto;

import com.example.finalproject.models.entity.OrderDetail;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link com.example.finalproject.models.entity.Day} entity
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DayDto implements Serializable {
      Long id;
      Boolean active;
      Date day;
      OrderDetailDto orderDetails;



}