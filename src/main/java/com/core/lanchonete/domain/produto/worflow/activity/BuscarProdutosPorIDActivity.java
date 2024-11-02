package com.core.lanchonete.domain.produto.worflow.activity;

import com.core.lanchonete.adapters.repository.ProdutoRepository;
import com.core.lanchonete.domain.produto.model.ProdutoDB;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BuscarProdutosPorIDActivity {

    private final ProdutoRepository produtoRepository;

    public List<ProdutoDB> buscarProdutosPorListaIds(List<Long> listaIds){
        var lista = produtoRepository.findAllById(listaIds);
        if(Objects.isNull(lista) || lista.isEmpty()){
            throw new IllegalArgumentException("Produtos não encontrado.");
        }
        return lista;
    }
}
