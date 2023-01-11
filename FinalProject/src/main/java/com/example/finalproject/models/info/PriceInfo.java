package com.example.finalproject.models.info;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public interface PriceInfo {
    Integer getRange();
    @JsonFormat(pattern = "YYYY.MM.DD")
    Date getStartDate();

    @JsonFormat(pattern = "YYYY.MM.DD")
    Date getEndDate();

    Double getPrice();

}
