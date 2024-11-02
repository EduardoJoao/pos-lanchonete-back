package com.core.lanchonete.domain.produto.mapper;

import com.core.lanchonete.domain.produto.model.ProdutoDB;
import org.openapitools.model.Produto;

public class ProdutoMapper {

    public static Produto mapProduto(ProdutoDB produtoDB){
        return Produto.builder()
            .id(produtoDB.getId())
            .nome(produtoDB.getNome())
            .descricao(produtoDB.getDescricao())
            .preco(produtoDB.getPreco())
            .categoria(produtoDB.getCategoria())
            .build();
    }

    public static ProdutoDB mapProdutoDB(Produto produto){
        return ProdutoDB.builder()
            .nome(produto.getNome())
            .descricao(produto.getDescricao())
            .preco(produto.getPreco())
            .categoria(produto.getCategoria())
            .ativo(Boolean.TRUE)
            .build();
    }
}
