package com.core.lanchonete.adapters.repository;

import com.core.lanchonete.domain.cliente.model.ClienteDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteDB, Long> {

    Optional<ClienteDB> findByCpf(String cpf);
}
