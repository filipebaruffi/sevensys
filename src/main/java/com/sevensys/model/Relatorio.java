package com.sevensys.model;

import javax.persistence.*;

@Entity
@Table(name = "relatorio")
public class Relatorio{

    @Id
    public int id;
    @Column(name = "id_cliente")
    public int idCliente;
    @Column(name = "id_conta")
    public int idConta;
    @Column(name = "totalMovimentacao")
    public int totalMovimentacao;
    @Column(name = "mesano")
    public String mesAno;
    @Column(name = "qnt_movi")
    public int qnt_movi;
}
