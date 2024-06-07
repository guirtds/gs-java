package com.example.beachcoins.service;

import com.example.beachcoins.controller.dto.UsuarioDTO;
import com.example.beachcoins.model.Usuario;
import com.example.beachcoins.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Cadastrando o usuario

    public Usuario cadastrarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setSobrenome(usuarioDTO.getSobrenome());
        usuario.setDataDeNascimento(usuarioDTO.getDataDeNascimento());
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setEmail(usuarioDTO.getEmail());
        return usuarioRepository.save(usuario);
    }

    // Atualizando o usuario

    public Usuario atualizarUsuario(Long id, UsuarioDTO novoUsuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if(usuarioExistente.isPresent()) {
            Usuario usuarioAtualizado = usuarioExistente.get();
            usuarioAtualizado.setNome(novoUsuario.getNome());
            usuarioAtualizado.setSobrenome(novoUsuario.getSobrenome());
            usuarioAtualizado.setDataDeNascimento(novoUsuario.getDataDeNascimento());
            usuarioAtualizado.setCpf(novoUsuario.getCpf());
            usuarioAtualizado.setEmail(novoUsuario.getEmail());
            return usuarioRepository.save(usuarioAtualizado);
        } else {
            throw new RuntimeException("Usuario não encontrado com o ID: " + id);
        }
    }

    // Listando os usuarios

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // Deletando os usuarios

    public void removerUsuarios(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuario não encontrado com o ID: " + id);
        }
    }

    @Transactional
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }
}
