package com.fabianesilva.estoque_material.infrastructure.repositories;

import com.fabianesilva.estoque_material.infrastructure.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}
