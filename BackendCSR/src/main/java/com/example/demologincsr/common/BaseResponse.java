package com.example.demologincsr.common;

import lombok.Setter;

@Setter
public class BaseResponse {
    private String code;

    private String message;

    private Object body;

    public BaseResponse(String code, String message, Object body) {
        this.code = code;
        this.message = message;
        this.body = body;
    }
}
