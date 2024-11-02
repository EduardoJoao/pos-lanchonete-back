package com.core.lanchonete.domain.pedido.worflow.activity;

import com.core.lanchonete.adapters.repository.PedidoRepository;
import com.core.lanchonete.domain.pedido.model.PedidoDB;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CriarPedidoActivty {

    private final PedidoRepository pedidoRepository;

    public void criarPedido(PedidoDB pedidoDB){
        pedidoRepository.save(pedidoDB);
    }
}
