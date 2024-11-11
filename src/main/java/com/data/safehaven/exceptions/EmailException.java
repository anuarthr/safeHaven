package com.ejemplo.excepciones;

import lombok.Getter;

@Getter
public class EmailException extends RuntimeException {
    private String email;
    public EmailException(String email) {
        super("El email '" + email + "' ya está registrado.");
        this.email = email;
    }

}
