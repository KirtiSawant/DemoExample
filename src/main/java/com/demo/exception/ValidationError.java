package com.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ValidationError {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> customValidationError(MethodArgumentNotValidException exception) {
        Error error = new Error(HttpStatus.BAD_REQUEST.value(), new Date(), "Validation Error",
                exception.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
