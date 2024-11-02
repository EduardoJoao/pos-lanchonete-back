package com.core.lanchonete.domain.produto.worflow.activity;

import com.core.lanchonete.adapters.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RemoverProdutoActivityTest {
    @InjectMocks
    private RemoverProdutoActivity removerProdutoActivity;

    @Mock
    private ProdutoRepository produtoRepository;
    @Test
    void removerProduto() {
        removerProdutoActivity.removerProduto(1L);
        verify(produtoRepository).desativarProduto(1L);
    }
}