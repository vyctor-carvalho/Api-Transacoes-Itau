package com.transacoes.itau.transacoes_api.sevice;

import com.transacoes.itau.transacoes_api.exception.InvalidValue;
import com.transacoes.itau.transacoes_api.model.EstatisticasModel;
import com.transacoes.itau.transacoes_api.model.Transacao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;

@Service
public class TransacaoService {
    ArrayList<Transacao> tranzacoesArmazenadas = new ArrayList<>();


    public void setTransacao(Transacao transacao) {

        //Pegando a hora atual do sistema
        LocalDateTime dataAtual = LocalDateTime.now();
        System.out.println("Hona do sistema -> " + dataAtual.getHour() + ":" + dataAtual.getMinute() + ":" + dataAtual.getSecond());

        //Pegando e convertendo a hora da transação
        OffsetDateTime horaEmOff = OffsetDateTime.parse(transacao.getHora());
        LocalDateTime horaDaTransacao = horaEmOff.toLocalDateTime();
        System.out.println("Hona do da transacao -> " + horaDaTransacao.getHour() + ":" + horaDaTransacao.getMinute() + ":" + horaDaTransacao.getSecond());


        if (transacao.getHora() == null || dataAtual.compareTo(horaDaTransacao) != 1 || transacao.getValor() < 0) throw new InvalidValue();

        tranzacoesArmazenadas.add(transacao);
    }

    public void deletTansacoies() {
        tranzacoesArmazenadas.clear();
    }

    public ResponseEntity<EstatisticasModel> getEstatisticas() {
        //Setando o modelo de retorno
        EstatisticasModel modelo = new EstatisticasModel();

        //Pegando a hora um minuto atrás
        LocalDateTime minusMinutes = LocalDateTime.now().minusMinutes(1);
        System.out.println("menus minuto -> "+ minusMinutes.getHour() + ":" + minusMinutes.getMinute() + ":" + minusMinutes.getSecond());

        //Criando variaveis para colocar os valores a sere setados no modelo
        int quantTansacoes = 0;
        double soma = 0;
        double media = 0;
        double max = 0;
        double min = 0;
        if (!tranzacoesArmazenadas.isEmpty()) min = tranzacoesArmazenadas.getFirst().getValor();
        //Acima eu pego o primeiro valor das transações para poder checar qual é o menor se a lista não estiver vazia

        for (Transacao i : tranzacoesArmazenadas) {
            OffsetDateTime dateTimeOff = OffsetDateTime.parse(i.getHora());
            LocalDateTime horaDaTrasacao = dateTimeOff.toLocalDateTime();

            //Checando se a transação ocorreu há um minuto
            if (minusMinutes.compareTo(horaDaTrasacao) == -1) {
                quantTansacoes++;
                soma+=i.getValor();
                if (i.getValor() > max) max = i.getValor();
                if (i.getValor() < min) min = i.getValor();
            };
        }

        if (soma != 0 && quantTansacoes != 0) media = soma/quantTansacoes;

        //setando os valores
        modelo.setCuont(quantTansacoes);
        modelo.setSum(soma);
        modelo.setAvg(media);
        modelo.setMin(min);
        modelo.setMax(max);

        return ResponseEntity.status(HttpStatus.OK).body(modelo);
    }

}
