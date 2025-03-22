package com.transacoes.itau.transacoes_api.web;

import com.transacoes.itau.transacoes_api.model.EstatisticasModel;
import com.transacoes.itau.transacoes_api.sevice.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaTransacoes {
    @Autowired
    TransacaoService transacaoService;

    @GetMapping()
    public ResponseEntity<EstatisticasModel> getEstatisticas() {
        return transacaoService.getEstatisticas();
    }

}
