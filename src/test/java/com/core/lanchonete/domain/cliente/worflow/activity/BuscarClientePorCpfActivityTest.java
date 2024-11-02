package com.core.lanchonete.domain.cliente.worflow.activity;

import com.core.lanchonete.adapters.repository.ClienteRepository;
import com.core.lanchonete.domain.cliente.model.ClienteDB;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BuscarClientePorCpfActivityTest {
    @InjectMocks
    private BuscarClientePorCpfActivity buscarClientePorCpfActivity;

    @Mock
    private ClienteRepository clienteRepository;

    @Test
    void buscarClientePorCpf() throws ChangeSetPersister.NotFoundException {
        var cliente = ClienteDB.builder().build();
        when(clienteRepository.findByCpf("1")).thenReturn(Optional.of(cliente));
        var response = buscarClientePorCpfActivity.buscarClientePorCpf("1");
        assertEquals(cliente, response);
    }
}