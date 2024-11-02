package com.core.lanchonete.domain.produto.worflow.activity;

import com.core.lanchonete.adapters.repository.ProdutoRepository;
import com.core.lanchonete.domain.produto.model.ProdutoDB;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.CategoriaProduto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuscarProdutosPorCategoriaActivity {

    private final ProdutoRepository produtoRepository;

    public List<ProdutoDB> buscarProdutosPorCategoria(CategoriaProduto categoria){
        return produtoRepository.findByCategoria(categoria);
    }
}
