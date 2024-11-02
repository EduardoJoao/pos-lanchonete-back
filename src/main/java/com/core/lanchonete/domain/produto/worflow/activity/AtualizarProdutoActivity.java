package com.core.lanchonete.domain.produto.worflow.activity;

import com.core.lanchonete.adapters.repository.ProdutoRepository;
import com.core.lanchonete.domain.produto.model.ProdutoDB;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.Produto;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
@RequiredArgsConstructor
public class AtualizarProdutoActivity {
    private final ProdutoRepository produtoRepository;

    public ProdutoDB atualizarProduto(ProdutoDB produtoBase, Produto produtoAlteracao){
        produtoBase.setNome(Objects.nonNull(produtoAlteracao.getNome()) ? produtoAlteracao.getNome() : produtoBase.getNome());
        produtoBase.setDescricao(Objects.nonNull(produtoAlteracao.getDescricao()) ? produtoAlteracao.getDescricao() : produtoBase.getDescricao());
        produtoBase.setPreco(Objects.nonNull(produtoAlteracao.getPreco()) ? produtoAlteracao.getPreco() : produtoBase.getPreco());
        produtoBase.setCategoria(Objects.nonNull(produtoAlteracao.getCategoria()) ? produtoAlteracao.getCategoria() : produtoBase.getCategoria());

        return produtoRepository.save(produtoBase);
    }
}
