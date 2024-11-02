package com.core.lanchonete.domain.pedido.worflow;

import com.core.lanchonete.domain.cliente.model.ClienteDB;
import com.core.lanchonete.domain.cliente.worflow.activity.BuscarClientePorCpfActivity;
import com.core.lanchonete.domain.pedido.model.PedidoDB;
import com.core.lanchonete.domain.pedido.worflow.activity.*;
import com.core.lanchonete.domain.produto.worflow.activity.BuscarProdutosPorIDActivity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PedidoWorkflowImplTest {

    @InjectMocks
    private PedidoWorkflowImpl pedidoWorkflow;

    @Mock
    private BuscarTodosPedidosActivty buscarTodosPedidosActivty;
    @Mock
    private  BuscarClientePorCpfActivity buscarClientePorCpfActivity;
    @Mock
    private  CriarPedidoActivty criarPedidoActivty;
    @Mock
    private  BuscarProdutosPorIDActivity buscarProdutosPorIDActivity;
    @Mock
    private  AtualizarStatusPedidoActivity atualizarStatusPedidoActivity;
    @Mock
    private  PublicaFilaCozinhaActivity publicaFilaCozinhaActivity;

    @Mock
    private BuscaPedidoPorIDActivty buscaPedidoPorIDActivty;


    private CriarPedidoRequest criarPedidoRequest;

    @BeforeEach
    void setUp() {
        criarPedidoRequest = CriarPedidoRequest.builder()
            .cpf("123")
            .total(1.0)
            .status(CriarPedidoRequest.StatusEnum.CRIADO)
            .build();
    }

    @Test
    void criarPedido() {

        pedidoWorkflow.criarPedido(criarPedidoRequest);

        verify(buscarClientePorCpfActivity).buscarClientePorCpf(criarPedidoRequest.getCpf());
        verify(buscarProdutosPorIDActivity).buscarProdutosPorListaIds(any());
        verify(criarPedidoActivty).criarPedido(any());
    }

    @Test
    void buscarPedidos() {
        var listaPedidos = List.of(PedidoDB.builder()
            .id(1L)
            .statusPedido(StatusPedidoEnum.CRIADO)
            .statusPagamento(StatusPagamentoEnum.PENDENTE)
            .produtoDBS(new ArrayList<>())
            .clienteDB(ClienteDB.builder().id(1L).build())
            .build());
        var listaPedidosMap = List.of(Pedido.builder()
            .id(1L)
            .statusPedido(StatusPedidoEnum.CRIADO)
            .statusPagamento(StatusPagamentoEnum.PENDENTE)
            .produtos(new ArrayList<>())
            .cliente(Cliente.builder().id(1L).build())
            .total(0.0)
            .build());
        when(buscarTodosPedidosActivty.listarTodosPedidos()).thenReturn(listaPedidos);

        var response = pedidoWorkflow.buscarPedidos();
        assertEquals(listaPedidosMap, response);
    }

    @Test
    void pagamentoPedido() {
        pedidoWorkflow.pagamentoPedido(1L);
        verify(atualizarStatusPedidoActivity).atualizarStatusPedido(1L, StatusPedidoEnum.CONFIRMADO, StatusPagamentoEnum.APROVADO);
        verify(publicaFilaCozinhaActivity).publicaFilaCozinha(any());
    }
}