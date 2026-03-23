package com.fabianesilva.estoque_material.infrastructure.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "empresa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    private String cnpj;

    @Column(name = "email", unique = true)
    @Email(message = "O campo (email) deve conter um e-mail válido")
    private String email;
    private String website;
    private String descricao;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
