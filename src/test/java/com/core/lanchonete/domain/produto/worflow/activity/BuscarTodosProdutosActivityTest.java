package com.core.lanchonete.domain.produto.worflow.activity;

import com.core.lanchonete.adapters.repository.ProdutoRepository;
import com.core.lanchonete.domain.pedido.model.PedidoDB;
import com.core.lanchonete.domain.produto.model.ProdutoDB;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BuscarTodosProdutosActivityTest {
    @InjectMocks
    private BuscarTodosProdutosActivity buscarTodosProdutosActivity;

    @Mock
    private ProdutoRepository produtoRepository;

    @Test
    void buscarTodosProdutos() {
        var listaPedido = List.of(ProdutoDB.builder().build());
        when(produtoRepository.findAll()).thenReturn(listaPedido);
        var response = buscarTodosProdutosActivity.buscarTodosProdutos();

        assertEquals(listaPedido, response);
    }
}