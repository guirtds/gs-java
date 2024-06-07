package com.example.beachcoins.controller;

import com.example.beachcoins.controller.dto.EcopontoDTO;
import com.example.beachcoins.model.Ecoponto;
import com.example.beachcoins.model.Usuario;
import com.example.beachcoins.service.EcopontoService;
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
@RequestMapping("/api/ecoponto")
public class EcopontoController {

    private final EcopontoService ecopontoService;

    @Autowired
    public EcopontoController(EcopontoService ecopontoService) {
        this.ecopontoService = ecopontoService;
    }

    @PostMapping
    public ResponseEntity<Ecoponto> cadastrarEcoponto(@Valid @RequestBody EcopontoDTO ecoponto) {
        Ecoponto novoEcoponto = ecopontoService.cadastrarEcoponto(ecoponto);

        EntityModel<Ecoponto> ecopontoHateoas = EntityModel.of(novoEcoponto,
                linkTo(methodOn(UsuarioController.class).buscarPorId(novoEcoponto.getId())).withSelfRel());

        return ResponseEntity.ok(ecopontoHateoas.getContent());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Ecoponto> atualizarEcoponto(@PathVariable Long id, @RequestBody EcopontoDTO novoEcoponto) {
        Ecoponto ecopontoAtualizado = ecopontoService.atualizarEcoponto(id, novoEcoponto);
        return ResponseEntity.ok(ecopontoAtualizado);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Ecoponto>> listarEcopontos() {
        List<Ecoponto> ecopontos = ecopontoService.listarEcopontos();
        return ResponseEntity.ok(ecopontos);
    }

    @GetMapping("/buscar/{id}")
    public EntityModel<Ecoponto> buscarPorId(@PathVariable Long id) {
        Ecoponto ecopontoEncontrado = ecopontoService.buscarPorId(id).orElseThrow();
        return EntityModel.of(ecopontoEncontrado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerEcopontos(@PathVariable Long id) {
        ecopontoService.removerEcopontos(id);
        return ResponseEntity.ok().build();
    }
}