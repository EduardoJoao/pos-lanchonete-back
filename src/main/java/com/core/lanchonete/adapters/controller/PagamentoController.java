package com.core.lanchonete.adapters.controller;

import com.core.lanchonete.domain.pedido.worflow.PedidoWorkflow;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.PagamentoApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PagamentoController implements PagamentoApi {

    private final PedidoWorkflow pedidoWorkflow;

    public ResponseEntity<Void> pagamentoIdPost(Long id) {
        pedidoWorkflow.pagamentoPedido(id);
        return ResponseEntity.ok(null);
    }
}
