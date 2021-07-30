package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@ControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler({CustomerNotFoundException.class})
    public ResponseEntity<ApiErrorResponse> customerNotFound(CustomerNotFoundException ex, WebRequest request) {
        ApiErrorResponse apiResponse = new ApiErrorResponse
                .ApiErrorResponseBuilder()
                .withDetail("Not able to find customer record")
                .withMessage("Not a valid user id.Please provide a valid user id or contact system admin.")
                .withError_code("404")
                .withStatus(HttpStatus.NOT_FOUND)
                .atTime(LocalDateTime.now(ZoneOffset.UTC))
                .build();
        return new ResponseEntity <ApiErrorResponse> (apiResponse, HttpStatus.NOT_FOUND);


    }
}