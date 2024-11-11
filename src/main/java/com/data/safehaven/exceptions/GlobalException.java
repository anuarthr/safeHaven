package com.data.safehaven.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(com.ejemplo.excepciones.EmailException.class)
    public ResponseEntity<ErrorMessage> handleEmailException(com.ejemplo.excepciones.EmailException ex) {
        ErrorMessage apiError = new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                "El email proporcionado ya está en uso",
                "EMAIL_ALREADY_EXISTS"
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }



}
