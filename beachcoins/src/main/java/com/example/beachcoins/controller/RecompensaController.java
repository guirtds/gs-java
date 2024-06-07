package com.example.beachcoins.controller;

import com.example.beachcoins.controller.dto.RecompensaDTO;
import com.example.beachcoins.model.Recompensa;
import com.example.beachcoins.model.Usuario;
import com.example.beachcoins.service.RecompensaService;
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
@RequestMapping("/api/recompensa")
public class RecompensaController {

    private final RecompensaService recompensaService;

    @Autowired
    public RecompensaController(RecompensaService recompensaService) {
        this.recompensaService = recompensaService;
    }

    @PostMapping
    public ResponseEntity<Recompensa> cadastrarRecompensa(@Valid @RequestBody RecompensaDTO recompensa) {
        Recompensa novaRecompensa = recompensaService.cadastrarRecompensa(recompensa);

        EntityModel<Recompensa> recompensaHateoas = EntityModel.of(novaRecompensa,
                linkTo(methodOn(RecompensaController.class).buscarPorId(novaRecompensa.getId())).withSelfRel());

        return ResponseEntity.ok(recompensaHateoas.getContent());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Recompensa> atualizarRecompensa(@PathVariable Long id, @RequestBody RecompensaDTO novaRecompensa) {
        Recompensa recompensaAtualizada = recompensaService.atualizarRecompensa(id, novaRecompensa);
        return ResponseEntity.ok(recompensaAtualizada);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Recompensa>> listarRecompensas() {
        List<Recompensa> recompensas = recompensaService.listarRecompensas();
        return ResponseEntity.ok(recompensas);
    }

    @GetMapping("/buscar/{id}")
    public EntityModel<Recompensa> buscarPorId(@PathVariable Long id) {
        Recompensa recompensaEncontrada = recompensaService.buscarPorId(id).orElseThrow();
        return EntityModel.of(recompensaEncontrada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerRecompensas(@PathVariable Long id) {
        recompensaService.removerRecompensas(id);
        return ResponseEntity.ok().build();
    }
}
