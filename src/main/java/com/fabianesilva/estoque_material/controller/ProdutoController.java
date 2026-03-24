package com.fabianesilva.estoque_material.controller;

import com.fabianesilva.estoque_material.business.ProdutoService;
import com.fabianesilva.estoque_material.infrastructure.entities.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Void> salvarProduto(@RequestBody Produto produto){
        produtoService.salvarProduto(produto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Produto>> buscarProduto(){
        return ResponseEntity.ok(produtoService.buscarProduto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable UUID id){
        return ResponseEntity.ok(produtoService.buscarProdutoPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProdutoPorId(@PathVariable UUID id){
        produtoService.deletarProdutopPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Produto> atualizarProdutoPorId(@RequestParam UUID id, @RequestBody Produto produto){
        produtoService.atualizarProdutoPorId(id, produto);
        return ResponseEntity.ok().build();
    }

}
