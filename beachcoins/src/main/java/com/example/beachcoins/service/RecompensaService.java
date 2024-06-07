package com.example.beachcoins.service;

import com.example.beachcoins.controller.dto.RecompensaDTO;
import com.example.beachcoins.model.Recompensa;
import com.example.beachcoins.repository.RecompensaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecompensaService {

    @Autowired
    private RecompensaRepository recompensaRepository;

    // Cadastrando a recompensa

    public Recompensa cadastrarRecompensa(RecompensaDTO recompensaDTO) {
        Recompensa recompensa = new Recompensa();
        recompensa.setNomeRecompensa(recompensaDTO.getNomeRecompensa());
        recompensa.setNomeEmpresa(recompensaDTO.getNomeEmpresa());
        recompensa.setValorRecompensa(recompensaDTO.getValorRecompensa());
        recompensa.setNivelRecompensa(recompensaDTO.getNivelRecompensa());
        recompensa.setTipoRecompensa(recompensaDTO.getTipoRecompensa());
        return recompensaRepository.save(recompensa);
    }

    // Atualizando a recompensa

    public Recompensa atualizarRecompensa(Long id, RecompensaDTO novaRecompensa) {
        Optional<Recompensa> recompensaExistente = recompensaRepository.findById(id);

        if(recompensaExistente.isPresent()) {
            Recompensa recompensaAtualizada = recompensaExistente.get();
            recompensaAtualizada.setNomeRecompensa(novaRecompensa.getNomeRecompensa());
            recompensaAtualizada.setNomeEmpresa(novaRecompensa.getNomeEmpresa());
            recompensaAtualizada.setValorRecompensa(novaRecompensa.getValorRecompensa());
            recompensaAtualizada.setNivelRecompensa(novaRecompensa.getNivelRecompensa());
            recompensaAtualizada.setTipoRecompensa(novaRecompensa.getTipoRecompensa());
            return recompensaRepository.save(recompensaAtualizada);
        } else {
            throw new RuntimeException("Recompensa não encontrada com o ID: " + id);
        }
    }

    // Listando as recompensas

    public List<Recompensa> listarRecompensas() {
        return recompensaRepository.findAll();
    }

    // Deletando as recompensas

    public void removerRecompensas(Long id) {
        if (recompensaRepository.existsById(id)) {
            recompensaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Recompensa não encontrada com o ID: " + id);
        }
    }

    @Transactional
    public Optional<Recompensa> buscarPorId(Long id) { return recompensaRepository.findById(id); }
}
