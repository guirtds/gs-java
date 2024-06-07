package com.example.beachcoins.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Recompensa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomeRecompensa;

    private String nomeEmpresa;

    private Float valorRecompensa;

    private Integer nivelRecompensa;

    private String tipoRecompensa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeRecompensa() {
        return nomeRecompensa;
    }

    public void setNomeRecompensa(String nomeRecompensa) {
        this.nomeRecompensa = nomeRecompensa;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public Float getValorRecompensa() {
        return valorRecompensa;
    }

    public void setValorRecompensa(Float valorRecompensa) {
        this.valorRecompensa = valorRecompensa;
    }

    public Integer getNivelRecompensa() {
        return nivelRecompensa;
    }

    public void setNivelRecompensa(Integer nivelRecompensa) {
        this.nivelRecompensa = nivelRecompensa;
    }

    public String getTipoRecompensa() {
        return tipoRecompensa;
    }

    public void setTipoRecompensa(String tipoRecompensa) {
        this.tipoRecompensa = tipoRecompensa;
    }
}
