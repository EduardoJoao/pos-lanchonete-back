package com.core.lanchonete.domain.cliente.worflow.activity;

import com.core.lanchonete.adapters.repository.ClienteRepository;
import com.core.lanchonete.domain.cliente.model.ClienteDB;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BuscarTodosClientesActivityTest {
    @InjectMocks
    private BuscarTodosClientesActivity buscarTodosClientesActivity;

    @Mock
    private ClienteRepository clienteRepository;

    @Test
    void buscarTodosClientes() {
        var listaCliente = List.of(ClienteDB.builder().build());
        when(clienteRepository.findAll()).thenReturn(listaCliente);
        var response = buscarTodosClientesActivity.buscarTodosClientes();

        assertEquals(listaCliente, response);
    }
}