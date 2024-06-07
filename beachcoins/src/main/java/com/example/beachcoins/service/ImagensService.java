package com.example.beachcoins.service;

import com.example.beachcoins.controller.dto.ImagensDTO;
import com.example.beachcoins.model.Imagens;
import com.example.beachcoins.model.PerfilUsuario;
import com.example.beachcoins.repository.ImagensRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagensService {

    @Autowired
    private ImagensRepository imagensRepository;

    // Cadastrando a imagem

    public Imagens cadastrarImagem(ImagensDTO imagensDTO) {
        Imagens imagens = new Imagens();
        imagens.setNomeImagem(imagensDTO.getNomeImagem());
        imagens.setDescricaoImagens(imagensDTO.getDescricaoImagens());
        imagens.setUrlImagem(imagensDTO.getUrlImagem());
        return imagensRepository.save(imagens);
    }

    // Atualizando a imagem

    public Imagens atualizarImagem(Long id, ImagensDTO novaImagem) {
        Optional<Imagens> imagemExistente = imagensRepository.findById(id);

        if(imagemExistente.isPresent()) {
            Imagens imagemAtualizada = imagemExistente.get();
            imagemAtualizada.setNomeImagem(novaImagem.getNomeImagem());
            imagemAtualizada.setDescricaoImagens(novaImagem.getDescricaoImagens());
            imagemAtualizada.setUrlImagem(novaImagem.getUrlImagem());
            return imagensRepository.save(imagemAtualizada);
        } else {
            throw new RuntimeException("Imagem não encontrada com o ID: " + id);
        }
    }

    // Listando as imagens

    public List<Imagens> listarImagens() {
        return imagensRepository.findAll();
    }

    // Deletando as imagens

    public void removerImagens(Long id) {
        if (imagensRepository.existsById(id)) {
            imagensRepository.deleteById(id);
        } else {
            throw new RuntimeException("Imagem não encontrada com o ID: " + id);
        }
    }

    @Transactional
    public Optional<Imagens> buscarPorId(Long id) { return imagensRepository.findById(id); }
}
