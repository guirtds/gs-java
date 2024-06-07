package com.example.beachcoins.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ecoponto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomeEcoponto;

    private String logradouroEcoponto;

    private Integer numeroEcoponto;

    private Integer qntItensColetados;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEcoponto() {
        return nomeEcoponto;
    }

    public void setNomeEcoponto(String nomeEcoponto) {
        this.nomeEcoponto = nomeEcoponto;
    }

    public String getLogradouroEcoponto() {
        return logradouroEcoponto;
    }

    public void setLogradouroEcoponto(String logradouroEcoponto) {
        this.logradouroEcoponto = logradouroEcoponto;
    }

    public Integer getNumeroEcoponto() {
        return numeroEcoponto;
    }

    public void setNumeroEcoponto(Integer numeroEcoponto) {
        this.numeroEcoponto = numeroEcoponto;
    }

    public Integer getQntItensColetados() {
        return qntItensColetados;
    }

    public void setQntItensColetados(Integer qntItensColetados) {
        this.qntItensColetados = qntItensColetados;
    }
}
