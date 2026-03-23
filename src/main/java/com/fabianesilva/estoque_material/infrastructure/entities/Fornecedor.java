package com.fabianesilva.estoque_material.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "fornecedor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    @Column(name = "email", unique = true)
    private String email;
    private String local;
    private String webSite;
    private String descricao;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
