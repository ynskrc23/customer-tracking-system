package com.karaca.customertrackingsystem.exception;

import com.karaca.customertrackingsystem.dto.responses.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<BaseResponse> handlerResourceNotFound(ResourceNotFoundException ex){
        BaseResponse baseResponse =
                BaseResponse.builder()
                        .code(String.format(HttpStatus.NOT_FOUND.toString()))
                        .message(ex.getLocalizedMessage())
                        .success(false)
                        .build();
        return new ResponseEntity<>(baseResponse, HttpStatus.NOT_FOUND);
    }
}