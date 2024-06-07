package com.example.beachcoins.controller;

import com.example.beachcoins.controller.dto.ImagensDTO;
import com.example.beachcoins.model.Imagens;
import com.example.beachcoins.model.Usuario;
import com.example.beachcoins.service.ImagensService;
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
@RequestMapping("/api/imagens")
public class ImagensController {

    private final ImagensService imagensService;

    @Autowired
    public ImagensController(ImagensService imagensService) {
        this.imagensService = imagensService;
    }

    @PostMapping
    public ResponseEntity<Imagens> cadastrarImagem(@Valid @RequestBody ImagensDTO imagens) {
        Imagens novaImagem = imagensService.cadastrarImagem(imagens);

        EntityModel<Imagens> imagemHateoas = EntityModel.of(novaImagem,
                linkTo(methodOn(UsuarioController.class).buscarPorId(novaImagem.getId())).withSelfRel());

        return ResponseEntity.ok(imagemHateoas.getContent());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Imagens> atualizarImagem(@PathVariable Long id, @RequestBody ImagensDTO novaImagem) {
        Imagens imagemAtualizada = imagensService.atualizarImagem(id, novaImagem);
        return ResponseEntity.ok(imagemAtualizada);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Imagens>> listarImagens() {
        List<Imagens> imagens = imagensService.listarImagens();
        return ResponseEntity.ok(imagens);
    }

    @GetMapping("/buscar/{id}")
    public EntityModel<Imagens> buscarPorId(@PathVariable Long id) {
        Imagens imagemEncontrada = imagensService.buscarPorId(id).orElseThrow();
        return EntityModel.of(imagemEncontrada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerImagens(@PathVariable Long id) {
        imagensService.removerImagens(id);
        return ResponseEntity.ok().build();
    }
}
