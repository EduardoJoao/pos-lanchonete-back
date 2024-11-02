package com.core.lanchonete.domain.produto.worflow.activity;

import com.core.lanchonete.adapters.repository.PedidoRepository;
import com.core.lanchonete.adapters.repository.ProdutoRepository;
import com.core.lanchonete.domain.pedido.model.PedidoDB;
import com.core.lanchonete.domain.pedido.worflow.activity.CriarPedidoActivty;
import com.core.lanchonete.domain.produto.model.ProdutoDB;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CriarProdutoActivityTest {
    @InjectMocks
    private CriarProdutoActivity criarProdutoActivity;

    @Mock
    private ProdutoRepository produtoRepository;

    @Test
    void criarProduto() {
        var produtoDB = ProdutoDB.builder().build();
        criarProdutoActivity.criarProduto(produtoDB);
        verify(produtoRepository).save(produtoDB);
    }
}