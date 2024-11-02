package com.core.lanchonete.domain.pedido.mapper;

import com.core.lanchonete.domain.cliente.mapper.ClienteMapper;
import com.core.lanchonete.domain.cliente.model.ClienteDB;
import com.core.lanchonete.domain.pedido.model.PedidoDB;
import com.core.lanchonete.domain.produto.mapper.ProdutoMapper;
import com.core.lanchonete.domain.produto.model.ProdutoDB;
import org.openapitools.model.*;

import java.util.List;
import java.util.Objects;

public class PedidoMapper {

    public static Pedido mapPedido(PedidoDB pedidoDB){
        var cliente = Objects.nonNull(pedidoDB.getClienteDB()) ? ClienteMapper.mapCliente(pedidoDB.getClienteDB()) : null;
        return Pedido
            .builder()
            .id(pedidoDB.getId())
            .cliente(cliente)
            .produtos(resolveListaProdutos(pedidoDB.getProdutoDBS()))
            .statusPedido(pedidoDB.getStatusPedido())
            .statusPagamento(pedidoDB.getStatusPagamento())
            .total(pedidoDB.getTotal())
            .build();
    }

    public static PedidoDB mapPedidoDB(CriarPedidoRequest criarPedidoRequest, ClienteDB clienteDB, List<ProdutoDB> produtoDBList){
        return PedidoDB.builder()
            .clienteDB(clienteDB)
            .produtoDBS(produtoDBList)
            .statusPedido(StatusPedidoEnum.CRIADO)
            .statusPagamento(StatusPagamentoEnum.PENDENTE)
            .total(criarPedidoRequest.getTotal())
            .build();
    }

    private static List<Produto> resolveListaProdutos(List<ProdutoDB> listaProdutos){
        return listaProdutos.stream().map(ProdutoMapper::mapProduto).toList();
    }
}
