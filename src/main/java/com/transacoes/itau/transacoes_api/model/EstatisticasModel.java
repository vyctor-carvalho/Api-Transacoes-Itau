package com.transacoes.itau.transacoes_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EstatisticasModel {
    private int cuont;
    private double sum;
    private double avg;
    private double min;
    private double max;
}
