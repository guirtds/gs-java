package com.example.beachcoins.controller;

import com.example.beachcoins.controller.dto.EmpresaParceiraDTO;
import com.example.beachcoins.model.EmpresaParceira;
import com.example.beachcoins.model.Usuario;
import com.example.beachcoins.service.EmpresaParceiraService;
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
@RequestMapping("/api/empresaparceira")
public class EmpresaParceiraController {

    private final EmpresaParceiraService empresaParceiraService;

    @Autowired
    public EmpresaParceiraController(EmpresaParceiraService empresaParceiraService) {
        this.empresaParceiraService = empresaParceiraService;
    }

    @PostMapping
    public ResponseEntity<EmpresaParceira> cadastrarEmpresaParceira(@Valid @RequestBody EmpresaParceiraDTO empresaParceira) {
        EmpresaParceira novaEmpresaParceira = empresaParceiraService.cadastrarEmpresaParceira(empresaParceira);

        EntityModel<EmpresaParceira> empresaParceiraHateoas = EntityModel.of(novaEmpresaParceira,
                linkTo(methodOn(UsuarioController.class).buscarPorId(novaEmpresaParceira.getId())).withSelfRel());

        return ResponseEntity.ok(empresaParceiraHateoas.getContent());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EmpresaParceira> atualizarEmpresaParceira(@PathVariable Long id, @RequestBody EmpresaParceiraDTO novaEmpresaParceira) {
        EmpresaParceira empresaParceiraAtualizada = empresaParceiraService.atualizarEmpresaParceira(id, novaEmpresaParceira);
        return ResponseEntity.ok(empresaParceiraAtualizada);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<EmpresaParceira>> listarEmpresasParceiras() {
        List<EmpresaParceira> empresaParceiras = empresaParceiraService.listarEmpresasParceiras();
        return ResponseEntity.ok(empresaParceiras);
    }

    @GetMapping("/buscar/{id}")
    public EntityModel<EmpresaParceira> buscarPorId(@PathVariable Long id) {
        EmpresaParceira empresaParceiraEncontrada = empresaParceiraService.buscarPorId(id).orElseThrow();
        return EntityModel.of(empresaParceiraEncontrada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerEmpresasParceiras(@PathVariable Long id) {
        empresaParceiraService.removerEmpresasParceiras(id);
        return ResponseEntity.ok().build();
    }
}
