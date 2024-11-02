package com.core.lanchonete.domain.produto.worflow.activity;

import com.core.lanchonete.adapters.repository.ProdutoRepository;
import com.core.lanchonete.domain.produto.model.ProdutoDB;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscarProdutoPorIdActivity {
    private final ProdutoRepository produtoRepository;
    public ProdutoDB buscarProdutoPorId(Long id){
        return produtoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado."));
    }
}
