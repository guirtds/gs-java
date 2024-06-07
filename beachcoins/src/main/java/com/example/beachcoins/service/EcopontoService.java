package com.example.beachcoins.service;

import com.example.beachcoins.controller.dto.EcopontoDTO;
import com.example.beachcoins.model.Ecoponto;
import com.example.beachcoins.model.EmpresaParceira;
import com.example.beachcoins.repository.EcopontoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EcopontoService {

    @Autowired
    private EcopontoRepository ecopontoRepository;

    // Cadastrando o ecoponto

    public Ecoponto cadastrarEcoponto(EcopontoDTO ecopontoDTO) {
        Ecoponto ecoponto = new Ecoponto();
        ecoponto.setNomeEcoponto(ecopontoDTO.getNomeEcoponto());
        ecoponto.setLogradouroEcoponto(ecopontoDTO.getLogradouroEcoponto());
        ecoponto.setNumeroEcoponto(ecopontoDTO.getNumeroEcoponto());
        ecoponto.setQntItensColetados(ecopontoDTO.getQntItensColetados());
        return ecopontoRepository.save(ecoponto);
    }

    // Atualizando o ecoponto

    public Ecoponto atualizarEcoponto(Long id, EcopontoDTO novoEcoponto) {
        Optional<Ecoponto> ecopontoExistente = ecopontoRepository.findById(id);

        if(ecopontoExistente.isPresent()) {
            Ecoponto ecopontoAtualizado = ecopontoExistente.get();
            ecopontoAtualizado.setNomeEcoponto(novoEcoponto.getNomeEcoponto());
            ecopontoAtualizado.setLogradouroEcoponto(novoEcoponto.getLogradouroEcoponto());
            ecopontoAtualizado.setNumeroEcoponto(novoEcoponto.getNumeroEcoponto());
            ecopontoAtualizado.setQntItensColetados(novoEcoponto.getQntItensColetados());
            return ecopontoRepository.save(ecopontoAtualizado);
        } else {
            throw new RuntimeException("Ecoponto não encontrado com o ID: " + id);
        }
    }

    // Listando os ecopontos

    public List<Ecoponto> listarEcopontos() {
        return ecopontoRepository.findAll();
    }

    // Deletando os ecopontos

    public void removerEcopontos(Long id) {
        if (ecopontoRepository.existsById(id)) {
            ecopontoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Ecoponto não encontrado com o ID: " + id);
        }
    }

    @Transactional
    public Optional<Ecoponto> buscarPorId(Long id) { return ecopontoRepository.findById(id); }
}
