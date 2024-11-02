package com.core.lanchonete.domain.pedido.worflow.activity;

import com.core.lanchonete.adapters.repository.PedidoRepository;
import com.core.lanchonete.domain.pedido.model.PedidoDB;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BuscarTodosPedidosActivtyTest {
    @InjectMocks
    private BuscarTodosPedidosActivty buscarTodosPedidosActivty;

    @Mock
    private PedidoRepository pedidoRepository;

    @Test
    void listarTodosPedidos() {
        var listaPedido = List.of(PedidoDB.builder().build());
        when(pedidoRepository.findAll()).thenReturn(listaPedido);
        var response = buscarTodosPedidosActivty.listarTodosPedidos();

        assertEquals(listaPedido, response);
    }
}