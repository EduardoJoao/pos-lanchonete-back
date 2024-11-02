package com.core.lanchonete.domain.cliente.worflow.activity;

import com.core.lanchonete.adapters.repository.ClienteRepository;
import com.core.lanchonete.domain.cliente.model.ClienteDB;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuscarTodosClientesActivity {
    private final ClienteRepository clienteRepository;
    public List<ClienteDB> buscarTodosClientes(){
        return clienteRepository.findAll();
    }
}
