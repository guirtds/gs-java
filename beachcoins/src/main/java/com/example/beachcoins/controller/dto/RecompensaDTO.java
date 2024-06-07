package com.example.beachcoins.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class RecompensaDTO {

    private Long id;

    @NotBlank
    private String nomeRecompensa;

    @NotBlank
    private String nomeEmpresa;

    @Positive
    @NotNull
    private Float valorRecompensa;

    @NotNull
    private Integer nivelRecompensa;

    @NotBlank
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
