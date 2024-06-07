package com.example.beachcoins.model;

import jakarta.persistence.*;

@Entity
public class PerfilUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
