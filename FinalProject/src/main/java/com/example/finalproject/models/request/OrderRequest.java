package com.example.finalproject.models.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
public class OrderRequest {
    String text;
    String name;
    String phone;
    String email;
    List<ChannelDaysRequest> channels;

}
