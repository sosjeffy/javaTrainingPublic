package com.example.demo.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiControllerAdvice {
    private static final Log LOGGER = LogFactory.getLog(ApiControllerAdvice.class);

    // @ExceptionHandler will let Spring know that we want this function to handle the specified exception
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<String> validationErrorHandler(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining("; "));
        LOGGER.info("Received invalid request with error(s): " + errorMessage);
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}


