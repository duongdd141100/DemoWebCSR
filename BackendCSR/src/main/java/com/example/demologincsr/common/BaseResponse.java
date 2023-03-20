package com.example.demologincsr.common;

import lombok.Data;
import lombok.Setter;

@Setter
@Data
public class BaseResponse<T> {
    private String code;

    private String message;

    private T body;

    public BaseResponse(String code, String message, T body) {
        this.code = code;
        this.message = message;
        this.body = body;
    }
}
