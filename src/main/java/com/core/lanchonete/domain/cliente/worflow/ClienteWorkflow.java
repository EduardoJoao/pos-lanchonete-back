package com.core.lanchonete.domain.cliente.worflow;

import org.openapitools.model.Cliente;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface ClienteWorkflow {

    void criarCliente(Cliente cliente);

    Cliente buscarCliente(String cpf);

    List<Cliente> buscarTodosClientes();
}
