package com.core.lanchonete.domain.produto.worflow.activity;

import com.core.lanchonete.adapters.repository.ProdutoRepository;
import com.core.lanchonete.domain.produto.model.ProdutoDB;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CriarProdutoActivity {

    private final ProdutoRepository produtoRepository;

    public void criarProduto(ProdutoDB produtoDB){
        produtoRepository.save(produtoDB);
    }
}