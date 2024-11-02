package com.core.lanchonete.adapters.controller;

import com.core.lanchonete.domain.cliente.worflow.ClienteWorkflow;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.ClientesApi;
import org.openapitools.model.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientesController implements ClientesApi {

    private final ClienteWorkflow clienteWorkflow;

    public ResponseEntity<Void> clientesPost(Cliente cliente) {
        clienteWorkflow.criarCliente(cliente);
        return ResponseEntity.noContent().build();
    }
    public ResponseEntity<Cliente> clientesCpfGet(String cpf) {
        return ResponseEntity.ok(clienteWorkflow.buscarCliente(cpf));
    }

    public ResponseEntity<List<Cliente>> clientesGet() {
        return ResponseEntity.ok(clienteWorkflow.buscarTodosClientes());
    }
}
