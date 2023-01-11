package com.example.finalproject.models.response;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public interface GetChannelResponse extends Serializable {
    Long getId();

    String getName();

    String getPhoto();
    Set<DiscountInfo> getDiscounts();
    interface DiscountInfo {
        Double getPercent();

        int getMinDay();
    }
    interface PriceInfo{
        double getPrice();
        Date getEndDate();
    }
}
