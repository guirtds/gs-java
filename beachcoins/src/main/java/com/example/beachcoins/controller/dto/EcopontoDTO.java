package com.example.beachcoins.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EcopontoDTO {

    private Long id;

    @NotBlank
    private String nomeEcoponto;

    @NotBlank
    private String logradouroEcoponto;

    @NotNull
    private Integer numeroEcoponto;

    @NotNull
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
