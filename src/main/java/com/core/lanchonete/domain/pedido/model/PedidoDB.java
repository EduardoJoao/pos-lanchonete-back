package com.core.lanchonete.domain.pedido.model;

import com.core.lanchonete.domain.produto.model.ProdutoDB;
import com.core.lanchonete.domain.cliente.model.ClienteDB;
import jakarta.persistence.*;
import lombok.*;
import org.openapitools.model.StatusPagamentoEnum;
import org.openapitools.model.StatusPedidoEnum;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Table(name = "tb_pedido")
public class PedidoDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = true)
    private ClienteDB clienteDB;

    @OneToMany
    @JoinColumn(name = "pedido_id")
    private List<ProdutoDB> produtoDBS;

    @Column(name = "status_pedido")
    @Enumerated(EnumType.STRING)
    private StatusPedidoEnum statusPedido;

    @Column(name = "status_pagamento")
    @Enumerated(EnumType.STRING)
    private StatusPagamentoEnum statusPagamento;

    @Column(name = "total")
    private double total;
}