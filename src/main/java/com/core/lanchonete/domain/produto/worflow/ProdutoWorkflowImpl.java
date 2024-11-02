package com.core.lanchonete.domain.produto.worflow;

import com.core.lanchonete.domain.produto.mapper.ProdutoMapper;
import com.core.lanchonete.domain.produto.model.ProdutoDB;
import com.core.lanchonete.domain.produto.worflow.activity.*;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.CategoriaProduto;
import org.openapitools.model.Produto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoWorkflowImpl implements ProdutoWorkflow{

    private final RemoverProdutoActivity removerProdutoActivity;
    private final BuscarProdutosPorCategoriaActivity buscarProdutosPorCategoriaActivity;
    private final CriarProdutoActivity criarProdutoActivity;
    private final BuscarProdutoPorIdActivity buscarProdutoPorIdActivity;
    private final AtualizarProdutoActivity atualizarProdutoActivity;
    private final BuscarTodosProdutosActivity buscarTodosProdutosActivity;

    @Override
    public void criarProduto(Produto produto) {
        var produtoBD = ProdutoMapper.mapProdutoDB(produto);
        criarProdutoActivity.criarProduto(produtoBD);
    }

    @Override
    public Produto editarProduto(Long id, Produto produto) {
        var produtoDb = buscarProdutoPorIdActivity.buscarProdutoPorId(id);
        return ProdutoMapper.mapProduto(atualizarProdutoActivity.atualizarProduto(produtoDb, produto));
    }

    @Override
    public void removerProduto(Long id) {
        removerProdutoActivity.removerProduto(id);
    }

    @Override
    public List<Produto> buscarProdutoPorCategoria(CategoriaProduto categoria) {
        List<ProdutoDB> listaProdutos;
        if(CategoriaProduto.TODOS.equals(categoria)) {
            listaProdutos = buscarTodosProdutosActivity.buscarTodosProdutos();
        }
        else {
            listaProdutos = buscarProdutosPorCategoriaActivity.buscarProdutosPorCategoria(categoria);
        }
        return listaProdutos.stream().map(ProdutoMapper::mapProduto).toList();
    }
}
