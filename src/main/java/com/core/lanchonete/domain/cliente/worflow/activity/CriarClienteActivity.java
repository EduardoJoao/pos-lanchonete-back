package com.core.lanchonete.domain.cliente.worflow.activity;

import com.core.lanchonete.adapters.repository.ClienteRepository;
import com.core.lanchonete.domain.cliente.model.ClienteDB;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CriarClienteActivity {

    private final ClienteRepository clienteRepository;

    public void criarCliente(ClienteDB clienteDB){
        clienteRepository.save(clienteDB);
    }
}
