package com.example.beachcoins.service;

import com.example.beachcoins.controller.dto.PerfilUsuarioDTO;
import com.example.beachcoins.model.PerfilUsuario;
import com.example.beachcoins.model.Recompensa;
import com.example.beachcoins.repository.PerfilUsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilUsuarioService {

    @Autowired
    private PerfilUsuarioRepository perfilUsuarioRepository;

    // Cadastrando o perfil do usuario

    public PerfilUsuario cadastrarPerfilUsuario(PerfilUsuarioDTO perfilUsuarioDTO) {
        PerfilUsuario perfilUsuario = new PerfilUsuario();
        perfilUsuario.setPontuacaoTotal(perfilUsuarioDTO.getPontuacaoTotal());
        return perfilUsuarioRepository.save(perfilUsuario);
    }

    // Atualizando o perfil do usuario

    public PerfilUsuario atualizarPerfilUsuario(Long id, PerfilUsuarioDTO novoPerfilUsuario) {
        Optional<PerfilUsuario> perfilUsuarioExistente = perfilUsuarioRepository.findById(id);

        if(perfilUsuarioExistente.isPresent()) {
            PerfilUsuario perfilUsuarioAtualizado = perfilUsuarioExistente.get();
            perfilUsuarioAtualizado.setPontuacaoTotal(novoPerfilUsuario.getPontuacaoTotal());
            return perfilUsuarioRepository.save(perfilUsuarioAtualizado);
        } else {
            throw new RuntimeException("Perfil do usuario não encontrado com o ID: " + id);
        }
    }

    // Listando os perfis dos usuarios

    public List<PerfilUsuario> listarPerfisUsuarios() {
        return perfilUsuarioRepository.findAll();
    }

    // Deletando os perfis dos usuarios

    public void removerPerfisUsuarios(Long id) {
        if (perfilUsuarioRepository.existsById(id)) {
            perfilUsuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Perfil do usuario não encontrado com o ID: " + id);
        }
    }

    @Transactional
    public Optional<PerfilUsuario> buscarPorId(Long id) { return perfilUsuarioRepository.findById(id); }
}
