package com.example.finalproject.models.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.finalproject.models.entity.Channel} entity
 */


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ChannelDto implements Serializable {
    private  Long id;
    private  Boolean active;
    private  String name;
    private  Integer orderNum;
    String photo;
}