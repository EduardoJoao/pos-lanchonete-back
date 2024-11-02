package com.core.lanchonete.domain.pedido.worflow.activity;

import com.core.lanchonete.adapters.repository.PedidoRepository;
import com.core.lanchonete.domain.pedido.model.PedidoDB;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CriarPedidoActivtyTest {

    @InjectMocks
    private CriarPedidoActivty criarPedidoActivty;

    @Mock
    private PedidoRepository pedidoRepository;

    @Test
    void criarPedido() {
        var pedidoDB = PedidoDB.builder().build();
        criarPedidoActivty.criarPedido(pedidoDB);
        verify(pedidoRepository).save(pedidoDB);
    }
}