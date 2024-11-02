package com.core.lanchonete.domain.produto.worflow;

import com.core.lanchonete.domain.pedido.worflow.PedidoWorkflowImpl;
import com.core.lanchonete.domain.produto.model.ProdutoDB;
import com.core.lanchonete.domain.produto.worflow.activity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.CategoriaProduto;
import org.openapitools.model.Produto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProdutoWorkflowImplTest {
    @InjectMocks
    private ProdutoWorkflowImpl produtoWorkflow;
    @Mock
    private RemoverProdutoActivity removerProdutoActivity;
    @Mock
    private BuscarProdutosPorCategoriaActivity buscarProdutosPorCategoriaActivity;
    @Mock
    private CriarProdutoActivity criarProdutoActivity;
    @Mock
    private BuscarProdutoPorIdActivity buscarProdutoPorIdActivity;
    @Mock
    private AtualizarProdutoActivity atualizarProdutoActivity;
    @Mock
    private BuscarTodosProdutosActivity buscarTodosProdutosActivity;

    private Produto produto;

    @BeforeEach
    void setUp() {
        produto = Produto.builder()
            .id(1L)
            .nome("Produto")
            .descricao("Produto")
            .categoria(CategoriaProduto.LANCHE)
            .preco(1.0)
            .build();
    }

    @Test
    void criarProduto() {
        produtoWorkflow.criarProduto(produto);
        verify(criarProdutoActivity).criarProduto(any());
    }

    @Test
    void editarProduto() {
    }

    @Test
    void removerProduto() {
        produtoWorkflow.removerProduto(1L);
        verify(removerProdutoActivity).removerProduto(1L);

    }

    @Test
    void buscarProdutoPorCategoria() {
        var listaProduto = List.of(ProdutoDB.builder()
            .id(1L)
            .nome("Produto")
            .descricao("Produto")
            .ativo(Boolean.TRUE)
            .categoria(CategoriaProduto.LANCHE)
            .preco(1.0)
            .build());
        var listaProdutoMap = List.of(Produto.builder()
            .id(1L)
            .nome("Produto")
            .descricao("Produto")
            .categoria(CategoriaProduto.LANCHE)
            .preco(1.0)
            .build());
        when(buscarProdutosPorCategoriaActivity.buscarProdutosPorCategoria(CategoriaProduto.LANCHE)).thenReturn(listaProduto);
        var response = produtoWorkflow.buscarProdutoPorCategoria(CategoriaProduto.LANCHE);
        assertEquals(response, listaProdutoMap);
    }
}