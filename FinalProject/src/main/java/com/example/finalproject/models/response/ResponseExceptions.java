package com.example.finalproject.models.response;

import com.example.finalproject.utils.RBundle;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseExceptions {
    String message;
    Object data;


    public static ResponseExceptions getResponse(String message) {

        return ResponseExceptions.builder()
                .message(message==null? RBundle.SINGLETON.periodMessage("success") :message)
                .build();
    }

    public static ResponseExceptions getErrorResponse(String message) {
        return ResponseExceptions.builder()
                .message(message==null?"Произошла неизвестная ошибка":message)
                .build();
    }

    public static ResponseExceptions getResponseWithBody(String message, Object data) {
        return ResponseExceptions.builder()
                .message(message)
                .data(data)
                .build();
    }
}
