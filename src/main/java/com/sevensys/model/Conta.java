package com.sevensys.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Conta {
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    @Column(name = "id")
    public int codigoConta;
    @Column(name = "id_cliente")
    public Long idCliente;
    @Column(name = "empresa")
    public String empresa;
    @Column(name = "saldo")
    public float Saldo;
    @Column(name = "dt_abertura")
    public String dataAbertura;


    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setSaldo(float saldo) {
        Saldo = saldo;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public int getCodigoConta() {
        return codigoConta;
    }

    public String getEmpresa() {
        return empresa;
    }

    public float getSaldo() {
        return Saldo;
    }
}
