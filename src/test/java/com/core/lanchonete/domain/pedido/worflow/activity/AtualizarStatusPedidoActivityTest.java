package com.core.lanchonete.domain.pedido.worflow.activity;

import com.core.lanchonete.adapters.repository.PedidoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.StatusPagamentoEnum;
import org.openapitools.model.StatusPedidoEnum;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AtualizarStatusPedidoActivityTest {
    @InjectMocks
    private AtualizarStatusPedidoActivity atualizarStatusPedidoActivity;

    @Mock
    private PedidoRepository pedidoRepository;
    @Test
    void atualizarStatusPedido() {
        atualizarStatusPedidoActivity.atualizarStatusPedido(1L, StatusPedidoEnum.CRIADO, StatusPagamentoEnum.PENDENTE);
        verify(pedidoRepository).atualizarStatusPedidoEPagamento(any(), any(), any());
    }
}