package com.sevensys.controller;

import com.sevensys.dto.ClienteDto;
import com.sevensys.model.Cliente;
import com.sevensys.repository.ClienteRepository;
import com.sevensys.repository.ContaRepository;
import com.sevensys.service.ClienteService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping({"/cliente"})
public class ClienteController {

    @Autowired
    private ContaRepository contaRepository;
    @Autowired
    private ClienteRepository repository;
    @Autowired
    private ClienteService service;
    ClienteController(ClienteRepository clienteRepository) {
        this.repository = clienteRepository;
    }
    @GetMapping(path = {"/busca"})
    public ResponseEntity<Cliente> buscaCliente(@RequestParam("id") final Long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = {"/novoCliente"},method = {RequestMethod.POST})
    public ResponseEntity<String> criaCliente(@RequestPart(value = "body") ClienteDto cliente) {
        return this.service.incluiCliente(cliente);
    }
}