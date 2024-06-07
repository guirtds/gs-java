package com.example.beachcoins.controller;

import com.example.beachcoins.controller.dto.UsuarioDTO;
import com.example.beachcoins.model.Usuario;
import com.example.beachcoins.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@Valid @RequestBody UsuarioDTO usuario) {
        Usuario novoUsuario = usuarioService.cadastrarUsuario(usuario);

        EntityModel<Usuario> usuarioHateoas = EntityModel.of(novoUsuario,
                linkTo(methodOn(UsuarioController.class).buscarPorId(novoUsuario.getId())).withSelfRel());

        return ResponseEntity.ok(usuarioHateoas.getContent());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO novoUsuario) {
        Usuario usuarioAtualizado = usuarioService.atualizarUsuario(id, novoUsuario);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/buscar/{id}")
    public EntityModel<Usuario> buscarPorId(@PathVariable Long id) {
        Usuario usuarioEncontrado = usuarioService.buscarPorId(id).orElseThrow();
        return EntityModel.of(usuarioEncontrado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerUsuarios(@PathVariable Long id) {
        usuarioService.removerUsuarios(id);
        return ResponseEntity.ok().build();
    }
}
