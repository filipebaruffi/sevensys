package com.sevensys.dto;


public class MovimentacaoDto {

    public Long id;
    public int codigoConta;
    public String tipoMovimentacao;
    public Float valorMovimentacao;
    public String dataMovimentacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCodigoConta() {
        return codigoConta;
    }

    public void setCodigoConta(int codigoConta) {
        this.codigoConta = codigoConta;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public Float getValorMovimentacao() {
        return valorMovimentacao;
    }

    public void setValorMovimentacao(Float valorMovimentacao) {
        this.valorMovimentacao = valorMovimentacao;
    }

    public String getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(String dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }
}
