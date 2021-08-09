package com.sevensys.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RelatorioEmpresa {

    @Id
    @Column(name = "id_cliente")
    public int idCliente;

    @Column(name = "receita")
    public String receita;

    @Column(name = "dt_abertura")
    public String dtAbertura;

    @Column(name = "valor_movimentacao")
    public String valorMovimentacao;


    public String getReceita() {
        return receita;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getDtAbertura() {
        return dtAbertura;
    }

    public String getValorMovimentacao() {
        return valorMovimentacao;
    }
}
