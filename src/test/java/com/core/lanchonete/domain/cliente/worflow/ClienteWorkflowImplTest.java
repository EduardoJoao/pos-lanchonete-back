package com.core.lanchonete.domain.cliente.worflow;

import com.core.lanchonete.domain.cliente.model.ClienteDB;
import com.core.lanchonete.domain.cliente.worflow.activity.BuscarClientePorCpfActivity;
import com.core.lanchonete.domain.cliente.worflow.activity.BuscarTodosClientesActivity;
import com.core.lanchonete.domain.cliente.worflow.activity.CriarClienteActivity;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.Cliente;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteWorkflowImplTest {
    @InjectMocks
    private ClienteWorkflowImpl clienteWorkflow;
    @Mock
    private CriarClienteActivity criarClienteActivity;
    @Mock
    private BuscarClientePorCpfActivity buscarClientePorCpfActivity;
    @Mock
    private BuscarTodosClientesActivity buscarTodosClientesActivity;
    private Cliente cliente;
    @BeforeEach
    void setUp() {
        cliente = Cliente.builder().build();
    }

    @Test
    void criarCliente() {
        clienteWorkflow.criarCliente(cliente);
        verify(criarClienteActivity).criarCliente(any());
    }

    @Test
    @SneakyThrows
    void buscarCliente() {
        var cliente = ClienteDB.builder().build();
        var clienteMap = Cliente.builder().build();
        when(buscarClientePorCpfActivity.buscarClientePorCpf(any())).thenReturn(cliente);

        var response = clienteWorkflow.buscarCliente("1");
        assertEquals(clienteMap, response);
    }

    @Test
    void buscarTodosClientes() {
        var listaClientes = List.of(ClienteDB.builder().build());
        var listaClientesMap = List.of(Cliente.builder().build());

        when(buscarTodosClientesActivity.buscarTodosClientes()).thenReturn(listaClientes);

        var response = clienteWorkflow.buscarTodosClientes();
        assertEquals(listaClientesMap, response);

    }
}