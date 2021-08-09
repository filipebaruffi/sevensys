package com.sevensys.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Movimentacao{
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    public Long id;
    @Column(name = "id_conta")
    public int codigoConta;
    @Column(name = "tipo_movimentacao")
    public String tipoMovimentacao;
    @Column(name = "vr_movi")
    public Float valorMovimentacao;
    @Column(name = "dt_movimentacao")
    public String dataMovimentacao;

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
    public Long getId() {
        return id;
    }

}
