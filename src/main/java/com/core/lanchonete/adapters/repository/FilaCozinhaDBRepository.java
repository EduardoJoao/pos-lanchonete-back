package com.core.lanchonete.adapters.repository;

import com.core.lanchonete.domain.pedido.model.FilaCozinhaDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilaCozinhaDBRepository extends JpaRepository<FilaCozinhaDB, Long> {
}
