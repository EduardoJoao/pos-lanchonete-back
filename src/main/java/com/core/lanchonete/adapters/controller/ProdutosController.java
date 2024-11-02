package com.core.lanchonete.adapters.controller;

import com.core.lanchonete.domain.produto.worflow.ProdutoWorkflow;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.ClientesApi;
import org.openapitools.api.ProdutosApi;
import org.openapitools.model.CategoriaProduto;
import org.openapitools.model.Cliente;
import org.openapitools.model.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProdutosController implements ProdutosApi {

    private final ProdutoWorkflow produtoWorkflow;

    public ResponseEntity<List<Produto>> produtosGet(CategoriaProduto categoria)  {
        return ResponseEntity.ok(produtoWorkflow.buscarProdutoPorCategoria(categoria));
    }

    public ResponseEntity<Void> produtosIdDelete(Long id) {
        produtoWorkflow.removerProduto(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Produto> produtosIdPut(Long id, Produto produto) {
        return ResponseEntity.ok(produtoWorkflow.editarProduto(id, produto));
    }

    public  ResponseEntity<Void> produtosPost(Produto produto) {
        produtoWorkflow.criarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
