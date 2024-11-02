package com.core.lanchonete.domain.pedido.worflow.activity;

import com.core.lanchonete.adapters.repository.PedidoRepository;
import com.core.lanchonete.domain.pedido.model.PedidoDB;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuscarTodosPedidosActivty {

    private final PedidoRepository pedidoRepository;

    public List<PedidoDB> listarTodosPedidos(){
        return pedidoRepository.findAll();
    }
}
