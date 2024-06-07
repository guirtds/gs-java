package com.example.beachcoins.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class ImagensDTO {

    private Long id;

    @NotBlank
    private String nomeImagem;

    @NotBlank
    private String descricaoImagens;

    @NotBlank
    private String urlImagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    public String getDescricaoImagens() {
        return descricaoImagens;
    }

    public void setDescricaoImagens(String descricaoImagens) {
        this.descricaoImagens = descricaoImagens;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}
