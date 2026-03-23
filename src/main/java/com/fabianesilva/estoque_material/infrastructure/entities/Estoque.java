package com.fabianesilva.estoque_material.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "estoque")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String produto;
    private String descricao;
    private String unidadeMedida;
    private Integer qtdeAtual;
    private Integer qtdeMin;
    private BigDecimal valorCompra;
    private BigDecimal valorVenda;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @OneToMany
    @JoinColumn(name = "fornecedor_id")
    private List<Fornecedor> fornecedor;


    @CreationTimestamp
    private LocalDateTime createdAt;
}
