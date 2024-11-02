package com.core.lanchonete.adapters.controller;

import com.core.lanchonete.domain.pedido.worflow.PedidoWorkflow;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.PedidosApi;
import org.openapitools.model.CriarPedidoRequest;
import org.openapitools.model.Pedido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PedidosController implements PedidosApi {

    private final PedidoWorkflow pedidoWorkflow;

    public ResponseEntity<List<Pedido>> pedidosGet(){
        return ResponseEntity.ok(pedidoWorkflow.buscarPedidos());
    }

    public ResponseEntity<Void> pedidosPost(CriarPedidoRequest criarPedidoRequest){
        pedidoWorkflow.criarPedido(criarPedidoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
