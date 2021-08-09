package com.sevensys.service;

import com.sevensys.dto.ClienteDto;
import com.sevensys.model.Cliente;
import com.sevensys.model.Conta;
import com.sevensys.model.Movimentacao;
import com.sevensys.repository.ClienteRepository;
import com.sevensys.repository.ContaRepository;
import com.sevensys.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ContaRepository contaRepository;
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public ResponseEntity<String> incluiCliente(ClienteDto clienteDto) {
    try {
        Cliente cliente = new Cliente();

        cliente.setNome(clienteDto.getNome());
        cliente.setTelefone(clienteDto.getTelefone());
        cliente.setEndereco(clienteDto.getEndereco());
        cliente.setNrDoc(clienteDto.getNrDoc());
        cliente.setDataNascimento(clienteDto.getDataNascimento());
        cliente.setTipoPessoa(clienteDto.getTipoPessoa());

        Conta conta = new Conta();

        this.clienteRepository.save(cliente);
        conta.setIdCliente(cliente.getId());
        conta.setEmpresa("XPTO");
        conta.setSaldo(0);
        conta.setDataAbertura(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        this.contaRepository.save(conta);


        Movimentacao movimentacao = new Movimentacao();

        movimentacao.setValorMovimentacao(100.00f);
        movimentacao.setCodigoConta(conta.getCodigoConta());
        movimentacao.setTipoMovimentacao("Debito");
        movimentacao.setDataMovimentacao(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        this.movimentacaoRepository.save(movimentacao);
        this.movimentacaoRepository.flush();


        return new ResponseEntity<>("CLIENTE CRIADO",HttpStatus.OK);
        }
    catch (Exception e) {
        return new ResponseEntity<>("ERRO AO INCLUIR CLIENTE", HttpStatus.BAD_REQUEST);
        }
    }
}
