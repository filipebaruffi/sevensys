package com.sevensys.controller;

import com.sevensys.model.Conta;
import com.sevensys.repository.ContaRepository;
import com.sevensys.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping({"/conta"})
public class ContaController {

    @Autowired
    private ContaRepository repository;
    @Autowired
    private ContaService service;

    ContaController(ContaRepository contaRepository) {
        this.repository = contaRepository;
    }
    @GetMapping(path = {"/getConta"})
    public ResponseEntity<Conta> buscaConta(@RequestParam("id") final Long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
}