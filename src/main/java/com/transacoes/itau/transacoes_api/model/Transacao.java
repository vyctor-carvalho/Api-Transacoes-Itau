package com.transacoes.itau.transacoes_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
public class Transacao {
    private double valor;
    private String hora;
}
