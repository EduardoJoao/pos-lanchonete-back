package com.core.lanchonete.domain.cliente.worflow.activity;

import com.core.lanchonete.adapters.repository.ClienteRepository;
import com.core.lanchonete.domain.cliente.model.ClienteDB;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CriarClienteActivityTest {

    @InjectMocks
    private CriarClienteActivity criarClienteActivity;

    @Mock
    private ClienteRepository clienteRepository;

    @Test
    void criarCliente() {
        var ClienteDb = ClienteDB.builder().build();
        criarClienteActivity.criarCliente(ClienteDb);
        verify(clienteRepository).save(ClienteDb);
    }
}