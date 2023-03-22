package com.example.demologincsr.common;

import com.example.demologincsr.entity.User;
import lombok.Data;
import lombok.Setter;

@Setter
@Data
public class BaseResponse<T> {
    private String code;

    private String message;

    private T body;

    public static BaseResponse ok(Object body) {
        return new BaseResponse<>(ResponseCodeEnum.OK.getCode(), ResponseCodeEnum.OK.getMessage(), body);
    }

    public static BaseResponse fail(String message) {
        return new BaseResponse<>(ResponseCodeEnum.FAILED.getCode(), ResponseCodeEnum.FAILED.getMessage(), message);
    }

    public BaseResponse(String code, String message, T body) {
        this.code = code;
        this.message = message;
        this.body = body;
    }
}
