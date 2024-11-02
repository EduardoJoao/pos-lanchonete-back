package com.core.lanchonete.adapters.repository;

import com.core.lanchonete.domain.pedido.model.PedidoDB;
import jakarta.transaction.Transactional;
import org.openapitools.model.StatusPagamentoEnum;
import org.openapitools.model.StatusPedidoEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoDB, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE PedidoDB p SET p.statusPedido = :statusPedido, p.statusPagamento = :statusPagamento WHERE p.id = :id")
    void atualizarStatusPedidoEPagamento(Long id, StatusPedidoEnum statusPedido, StatusPagamentoEnum statusPagamento);
}