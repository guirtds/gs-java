package com.example.beachcoins.controller;

import com.example.beachcoins.controller.dto.PerfilUsuarioDTO;
import com.example.beachcoins.model.PerfilUsuario;
import com.example.beachcoins.model.Usuario;
import com.example.beachcoins.service.PerfilUsuarioService;
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
@RequestMapping("/api/perfilusuario")
public class PerfilUsuarioController {

    private final PerfilUsuarioService perfilUsuarioService;

    @Autowired
    public PerfilUsuarioController(PerfilUsuarioService perfilUsuarioService) {
        this.perfilUsuarioService = perfilUsuarioService;
    }

    @PostMapping
    public ResponseEntity<PerfilUsuario> cadastrarPerfilUsuario(@Valid @RequestBody PerfilUsuarioDTO perfilUsuario) {
        PerfilUsuario novoPerfilUsuario = perfilUsuarioService.cadastrarPerfilUsuario(perfilUsuario);

        EntityModel<PerfilUsuario> perfilUsuarioHateoas = EntityModel.of(novoPerfilUsuario,
                linkTo(methodOn(PerfilUsuarioController.class).buscarPorId(novoPerfilUsuario.getId())).withSelfRel());

        return ResponseEntity.ok(perfilUsuarioHateoas.getContent());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PerfilUsuario> atualizarPerfilUsuario(@PathVariable Long id, @RequestBody PerfilUsuarioDTO novoPerfilUsuario) {
        PerfilUsuario perfilUsuarioAtualizado = perfilUsuarioService.atualizarPerfilUsuario(id, novoPerfilUsuario);
        return ResponseEntity.ok(perfilUsuarioAtualizado);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<PerfilUsuario>> listarPerfisUsuarios() {
        List<PerfilUsuario> perfilUsuarios = perfilUsuarioService.listarPerfisUsuarios();
        return ResponseEntity.ok(perfilUsuarios);
    }

    @GetMapping("/buscar/{id}")
    public EntityModel<PerfilUsuario> buscarPorId(@PathVariable Long id) {
        PerfilUsuario perfilUsuarioEncontrado = perfilUsuarioService.buscarPorId(id).orElseThrow();
        return EntityModel.of(perfilUsuarioEncontrado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPerfiUsuarios(@PathVariable Long id) {
        perfilUsuarioService.removerPerfisUsuarios(id);
        return ResponseEntity.ok().build();
    }
}
