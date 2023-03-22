package com.example.demologincsr.common;

import lombok.Getter;

@Getter
public enum ResponseCodeEnum {

    OK("200", "Successfully"),
    FAILED("400", "Bad Request");

    private String code;

    private String message;

    ResponseCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
