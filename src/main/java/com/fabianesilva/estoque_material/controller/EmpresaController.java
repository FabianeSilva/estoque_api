package com.fabianesilva.estoque_material.controller;

import com.fabianesilva.estoque_material.business.EmpresaService;
import com.fabianesilva.estoque_material.infrastructure.entities.Empresa;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/empresa")
@RequiredArgsConstructor
public class EmpresaController {

    private final EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Void> salvarEmpresa(@Valid @RequestBody Empresa empresa) {
        empresaService.salvarEmpresa(empresa);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> buscarEmpresa(){
        return ResponseEntity.ok(empresaService.buscarEmpresa());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Empresa> buscarEmpresaPorId(@PathVariable UUID id){
        return ResponseEntity.ok(empresaService.buscarEmpresaPorId(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Empresa> buscarEmpresaPorEmail(@PathVariable String email){
        return ResponseEntity.ok(empresaService.buscarEmpresaPorEmail(email));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEmpresaPorId(@PathVariable(name = "id") UUID id){
        empresaService.deletarEmpresaPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarEmpresa(@RequestParam(name = "id") UUID id, @RequestBody Empresa empresa){
        empresaService.atualizarEmpresaPorId(id, empresa);
        return ResponseEntity.ok().build();

    }
}
