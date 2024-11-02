package com.core.lanchonete.domain.cliente.worflow;

import com.core.lanchonete.domain.cliente.mapper.ClienteMapper;
import com.core.lanchonete.domain.cliente.worflow.activity.BuscarClientePorCpfActivity;
import com.core.lanchonete.domain.cliente.worflow.activity.BuscarTodosClientesActivity;
import com.core.lanchonete.domain.cliente.worflow.activity.CriarClienteActivity;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteWorkflowImpl implements ClienteWorkflow {
    private final CriarClienteActivity criarClienteActivity;
    private final BuscarClientePorCpfActivity buscarClientePorCpfActivity;
    private final BuscarTodosClientesActivity buscarTodosClientesActivity;
    @Override
    public void criarCliente(Cliente cliente) {
        var clienteDB = ClienteMapper.mapClienteDB(cliente);
        criarClienteActivity.criarCliente(clienteDB);
    }

    @Override
    public Cliente buscarCliente(String cpf) {
        var cliente = buscarClientePorCpfActivity.buscarClientePorCpf(cpf);
        return ClienteMapper.mapCliente(cliente);
    }

    @Override
    public List<Cliente> buscarTodosClientes() {
        var listaClientes = buscarTodosClientesActivity.buscarTodosClientes();
        return listaClientes.stream().map(ClienteMapper::mapCliente).toList();
    }
}
