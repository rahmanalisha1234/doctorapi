package com.example.doctorapi.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleClientError(ResourceNotFoundException ex){
        Map<String,Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("error_code", 404);
        error.put("error_message","Data Not Found");
        error.put("message",ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<Map<String,Object>> handleServerError(ResourceNotFoundException ex){
            Map<String,Object> error = new HashMap<>();
            error.put("timestamp", LocalDateTime.now());
            error.put("error_code", 500);
            error.put("error_message","Internal Server Error");
            error.put("message",ex.getMessage());
            return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
        }



    }
