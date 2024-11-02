package com.core.lanchonete.domain.pedido.worflow;

import com.core.lanchonete.domain.cliente.model.ClienteDB;
import com.core.lanchonete.domain.cliente.worflow.activity.BuscarClientePorCpfActivity;
import com.core.lanchonete.domain.pedido.mapper.PedidoMapper;
import com.core.lanchonete.domain.pedido.model.FilaCozinhaDB;
import com.core.lanchonete.domain.pedido.worflow.activity.*;
import com.core.lanchonete.domain.produto.model.ProdutoDB;
import com.core.lanchonete.domain.produto.worflow.activity.BuscarProdutosPorIDActivity;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.CriarPedidoRequest;
import org.openapitools.model.Pedido;
import org.openapitools.model.StatusPagamentoEnum;
import org.openapitools.model.StatusPedidoEnum;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PedidoWorkflowImpl implements PedidoWorkflow {
    private final BuscarTodosPedidosActivty buscarTodosPedidosActivty;
    private final BuscarClientePorCpfActivity buscarClientePorCpfActivity;
    private final CriarPedidoActivty criarPedidoActivty;
    private final BuscarProdutosPorIDActivity buscarProdutosPorIDActivity;
    private final AtualizarStatusPedidoActivity atualizarStatusPedidoActivity;
    private final BuscaPedidoPorIDActivty buscaPedidoPorIDActivty;
    private final PublicaFilaCozinhaActivity publicaFilaCozinhaActivity;
    @Override
    public void criarPedido(CriarPedidoRequest pedido){
        ClienteDB cliente = null;
        if(Objects.nonNull(pedido.getCpf())){
            cliente = buscarClientePorCpfActivity.buscarClientePorCpf(pedido.getCpf());
        }
        var listaDeProdutos = buscarProdutosPorIDActivity.buscarProdutosPorListaIds(pedido.getProdutos());
        pedido.setTotal(listaDeProdutos.stream().map(ProdutoDB::getPreco).reduce(0.0, Double::sum));
        var pedidoDb = PedidoMapper.mapPedidoDB(pedido, cliente, listaDeProdutos);
        criarPedidoActivty.criarPedido(pedidoDb);
    }

    @Override
    public List<Pedido> buscarPedidos() {
        var listaPedidos = buscarTodosPedidosActivty.listarTodosPedidos();
        return listaPedidos.stream().map(PedidoMapper::mapPedido).toList();
    }

    @Override
    public void pagamentoPedido(Long idPedido) {
        atualizarStatusPedidoActivity.atualizarStatusPedido(idPedido, StatusPedidoEnum.CONFIRMADO, StatusPagamentoEnum.APROVADO);
        var pedidoAtualizado = buscaPedidoPorIDActivty.buscarPedidoPorId(idPedido);
        FilaCozinhaDB filaCozinhaDB = FilaCozinhaDB.builder()
            .pedidoDB(pedidoAtualizado)
            .build();
        publicaFilaCozinhaActivity.publicaFilaCozinha(filaCozinhaDB);
    }
}
