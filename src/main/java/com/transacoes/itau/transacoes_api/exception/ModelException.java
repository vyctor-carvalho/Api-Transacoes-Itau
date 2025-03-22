package com.transacoes.itau.transacoes_api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Setter
@Getter
public class ModelException {
    private HttpStatus httpStatus;
    private String mensage;
}
