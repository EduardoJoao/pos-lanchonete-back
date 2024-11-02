package com.core.lanchonete.domain.cliente.worflow.activity;

import com.core.lanchonete.adapters.repository.ClienteRepository;
import com.core.lanchonete.domain.cliente.model.ClienteDB;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class BuscarClientePorCpfActivity {

    private final ClienteRepository clienteRepository;

    public ClienteDB buscarClientePorCpf(String cpf){
        return clienteRepository.findByCpf(cpf)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
    }
}
