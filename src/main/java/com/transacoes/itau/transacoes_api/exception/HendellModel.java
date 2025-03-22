package com.transacoes.itau.transacoes_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HendellModel {
    @ExceptionHandler(InvalidValue.class)
    public ResponseEntity<ModelException> invalidDate(InvalidValue ex) {
        ModelException error = new ModelException(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public  ResponseEntity<ModelException> invalidJson() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

}
