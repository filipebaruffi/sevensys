package com.sevensys.service;

import com.sevensys.dto.MovimentacaoDto;
import com.sevensys.model.Movimentacao;
import com.sevensys.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public ResponseEntity<String> incluiMovimentacao(MovimentacaoDto movimentacaoDto) {
        try {
            Movimentacao movimentacao = new Movimentacao();

            movimentacao.setCodigoConta(movimentacaoDto.getCodigoConta());
            movimentacao.setDataMovimentacao(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            movimentacao.setTipoMovimentacao(movimentacaoDto.getTipoMovimentacao());
            movimentacao.setValorMovimentacao(movimentacaoDto.getValorMovimentacao());

            this.movimentacaoRepository.save(movimentacao);
            this.movimentacaoRepository.flush();

            return new ResponseEntity<>("MOVIMENTACAO CRIADA", HttpStatus.OK);
        }
        catch (Exception e) {

            return new ResponseEntity<>("ERRO AO INCLUIR MOVIMENTACAO", HttpStatus.BAD_REQUEST);
        }
    }

}
