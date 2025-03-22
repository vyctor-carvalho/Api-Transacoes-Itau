package com.transacoes.itau.transacoes_api.web;

import com.transacoes.itau.transacoes_api.exception.ModelException;
import com.transacoes.itau.transacoes_api.model.Transacao;
import com.transacoes.itau.transacoes_api.sevice.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/transacao")
public class TransacoesController {
    @Autowired
    private TransacaoService transacaoService;

    @PostMapping()
    public ResponseEntity setTransacao(@RequestBody Transacao transacao) {
        transacaoService.setTransacao(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @DeleteMapping()
    public void deletTransacoes() {
        transacaoService.deletTansacoies();
    }

}
