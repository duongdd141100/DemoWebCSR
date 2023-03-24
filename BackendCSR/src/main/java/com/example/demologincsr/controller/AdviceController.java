package com.example.demologincsr.controller;

import com.example.demologincsr.common.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse<String>> handleRuntimeException(Exception e) {
        return ResponseEntity.badRequest().body(BaseResponse.fail(e.getMessage()));
    }
}
