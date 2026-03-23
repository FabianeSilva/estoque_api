package com.fabianesilva.estoque_material.infrastructure.repositories;

import com.fabianesilva.estoque_material.infrastructure.entities.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FornecedorRepository extends JpaRepository<Fornecedor, UUID> {
}
