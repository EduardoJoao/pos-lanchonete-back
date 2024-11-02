package com.core.lanchonete.domain.produto.worflow.activity;

import com.core.lanchonete.adapters.repository.ProdutoRepository;
import com.core.lanchonete.domain.produto.model.ProdutoDB;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuscarTodosProdutosActivity {

    private final ProdutoRepository produtoRepository;

    public List<ProdutoDB> buscarTodosProdutos(){
        return produtoRepository.findAll();
    }
}
