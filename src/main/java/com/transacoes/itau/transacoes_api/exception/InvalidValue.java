package com.transacoes.itau.transacoes_api.exception;

public class InvalidValue extends RuntimeException {
    public InvalidValue(String message) {
        super(message);
    }
    public InvalidValue() {
        super("A data inserida está errada");
    }
}
