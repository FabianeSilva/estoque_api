package com.fabianesilva.estoque_material.infrastructure.repositories;

import com.fabianesilva.estoque_material.infrastructure.entities.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EstoqueRepository extends JpaRepository<Estoque, UUID> {
}
