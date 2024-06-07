package com.example.beachcoins.controller.dto;

import jakarta.validation.constraints.NotNull;

public class PerfilUsuarioDTO {

    private Long id;

    @NotNull
    private Float pontuacaoTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getPontuacaoTotal() {
        return pontuacaoTotal;
    }

    public void setPontuacaoTotal(Float pontuacaoTotal) {
        this.pontuacaoTotal = pontuacaoTotal;
    }
}
