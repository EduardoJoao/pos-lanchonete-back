package com.core.lanchonete.domain.produto.worflow;

import org.openapitools.model.CategoriaProduto;
import org.openapitools.model.Produto;

import java.util.List;

public interface ProdutoWorkflow {

    void criarProduto(Produto produto);

    Produto editarProduto(Long id, Produto produto);

    void removerProduto(Long id);

    List<Produto> buscarProdutoPorCategoria(CategoriaProduto categoria);

}
