package com.sevensys.controller;

import com.sevensys.dto.MovimentacaoDto;
import com.sevensys.model.Movimentacao;
import com.sevensys.repository.MovimentacaoRepository;
import com.sevensys.repository.RelatorioRepository;
import com.sevensys.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping({"/movimentacao"})
public class MovimentacaoController {

    @Autowired
    private RelatorioRepository relatorio;
    @Autowired
    private MovimentacaoRepository repository;
    @Autowired
    private MovimentacaoService service;
    MovimentacaoController(MovimentacaoRepository movimentacaoRepository) {
        this.repository = movimentacaoRepository;
    }
    @GetMapping(path = {"/getMovimentacao"})
    public ResponseEntity<Movimentacao> buscaMovimentacao(@RequestParam("id") final Long id) {

        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = {"/novaMovimentacao"},method = {RequestMethod.POST})

    public ResponseEntity<String> criaMovimentacao(@RequestPart(value = "body") MovimentacaoDto movimentacao) {
        return this.service.incluiMovimentacao(movimentacao);
    }

}