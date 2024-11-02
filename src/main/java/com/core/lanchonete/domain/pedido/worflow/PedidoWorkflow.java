package com.core.lanchonete.domain.pedido.worflow;

import org.openapitools.model.CriarPedidoRequest;
import org.openapitools.model.Pedido;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface PedidoWorkflow {

    void criarPedido(CriarPedidoRequest criarPedidoRequest);

    List<Pedido> buscarPedidos();

    void pagamentoPedido(Long idPedido);
}
