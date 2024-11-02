package com.core.lanchonete.adapters.repository;

import com.core.lanchonete.domain.produto.model.ProdutoDB;
import jakarta.transaction.Transactional;
import org.openapitools.model.CategoriaProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoDB, Long> {

    List<ProdutoDB> findByCategoria(CategoriaProduto categoria);

    @Modifying
    @Transactional
    @Query("UPDATE ProdutoDB p SET p.ativo = false WHERE p.id = :id")
    void desativarProduto(Long id);
}
