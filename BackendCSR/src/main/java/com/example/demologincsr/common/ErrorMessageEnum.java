package com.example.demologincsr.common;

import lombok.Getter;

@Getter
public enum ErrorMessageEnum {
    LOGIN_FAILED("001001", "Login Failed"),

    TOKEN_EMPTY("001002", "Token Empty"),

    TOKEN_INVALID("001003", "Token Invalid"),

    CREATE_TOKEN_FAILED("001004", "Create Token Failed");

    private String code;

    private String message;

    ErrorMessageEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ErrorMessageEnum typeOf(String code) {
        for (ErrorMessageEnum messageEnum : ErrorMessageEnum.values()) {
            if (messageEnum.code.equals(code)) {
                return messageEnum;
            }
        }
        throw new IllegalArgumentException();
    }
}
