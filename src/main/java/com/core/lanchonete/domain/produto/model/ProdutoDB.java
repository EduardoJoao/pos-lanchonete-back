package com.core.lanchonete.domain.produto.model;

import jakarta.persistence.*;
import lombok.*;
import org.openapitools.model.CategoriaProduto;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tb_produto")
public class ProdutoDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "categoria")
    @Enumerated(EnumType.STRING)
    private CategoriaProduto categoria;

    @Column(name = "ativo")
    private Boolean ativo;
}
