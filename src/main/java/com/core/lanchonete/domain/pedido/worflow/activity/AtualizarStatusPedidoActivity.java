package com.core.lanchonete.domain.pedido.worflow.activity;

import com.core.lanchonete.adapters.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.StatusPagamentoEnum;
import org.openapitools.model.StatusPedidoEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AtualizarStatusPedidoActivity {

    private final PedidoRepository pedidoRepository;

    public void atualizarStatusPedido(Long id, StatusPedidoEnum statusPedido, StatusPagamentoEnum statusPagamento){
        pedidoRepository.atualizarStatusPedidoEPagamento(id, statusPedido, statusPagamento);
    }
}
