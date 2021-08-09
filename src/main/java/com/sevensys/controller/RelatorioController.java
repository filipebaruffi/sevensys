package com.sevensys.controller;

import com.sevensys.model.Relatorio;
import com.sevensys.service.RelatorioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sevensys.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping({"/relatorio"})

public class RelatorioController {

    @Autowired
    private RelatorioRepository repository;
    @Autowired
    private RelatorioService relatorioService;


    RelatorioController(RelatorioRepository relatorioRepository) {
        this.repository = relatorioRepository;
    }

    @GetMapping(path = {"/getRelatorioCliente"})
    public Relatorio buscaRelatorio(@RequestParam("idConta") final int id) {
        this.relatorioService.atualizaRelatorio();

        return repository.findByidConta(id);
    }

    @GetMapping(path = {"/getRelatorioEmpresa"})
    public List buscaRelatorioEmpresa() {
        return relatorioService.receitaEmpresa();
    }
}








