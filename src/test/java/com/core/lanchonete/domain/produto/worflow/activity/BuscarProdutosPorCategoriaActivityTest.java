package com.core.lanchonete.domain.produto.worflow.activity;

import com.core.lanchonete.adapters.repository.ProdutoRepository;
import com.core.lanchonete.domain.produto.model.ProdutoDB;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BuscarProdutosPorCategoriaActivityTest {
    @InjectMocks
    private BuscarProdutosPorCategoriaActivity buscarProdutosPorCategoriaActivity;

    @Mock
    private ProdutoRepository produtoRepository;

    @Test
    void buscarProdutosPorCategoria() {
        var listaPedido = List.of(ProdutoDB.builder().build());
        when(produtoRepository.findByCategoria(any())).thenReturn(listaPedido);
        var response = buscarProdutosPorCategoriaActivity.buscarProdutosPorCategoria(any());

        assertEquals(listaPedido, response);
    }
}