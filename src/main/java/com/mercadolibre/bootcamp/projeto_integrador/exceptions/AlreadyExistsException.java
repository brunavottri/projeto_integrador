package com.mercadolibre.bootcamp.projeto_integrador.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class AlreadyExistsException extends CustomException{
    /**
     * Lança uma CustomException com HTTP Status 409.
     * @throws CustomException
     * @param name
     */
    public AlreadyExistsException(String name) {
        super(name, name + " already exists", HttpStatus.CONFLICT, LocalDateTime.now());
    }
}
