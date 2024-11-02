package com.core.lanchonete.domain.produto.worflow.activity;

import com.core.lanchonete.adapters.repository.ProdutoRepository;
import com.core.lanchonete.domain.produto.model.ProdutoDB;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BuscarProdutoPorIdActivityTest {
    @InjectMocks
    private BuscarProdutoPorIdActivity buscarProdutoPorIdActivity;

    @Mock
    private ProdutoRepository produtoRepository;
    @Test
    void buscarProdutoPorId() {
        var produtoDB = ProdutoDB.builder().build();
        when(produtoRepository.findById(any())).thenReturn(Optional.of(produtoDB));
        var response = buscarProdutoPorIdActivity.buscarProdutoPorId(any());

        assertEquals(produtoDB, response);
    }
}