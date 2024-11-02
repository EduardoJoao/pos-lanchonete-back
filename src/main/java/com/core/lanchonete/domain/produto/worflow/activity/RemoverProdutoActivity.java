package com.core.lanchonete.domain.produto.worflow.activity;

import com.core.lanchonete.adapters.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemoverProdutoActivity {

    private final ProdutoRepository produtoRepository;

    public void removerProduto(Long id){
        produtoRepository.desativarProduto(id);
    }
}
