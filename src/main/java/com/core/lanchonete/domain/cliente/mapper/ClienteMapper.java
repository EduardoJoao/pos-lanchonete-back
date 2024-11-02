package com.core.lanchonete.domain.cliente.mapper;

import com.core.lanchonete.domain.cliente.model.ClienteDB;
import org.openapitools.model.Cliente;

public class ClienteMapper {

    public static Cliente mapCliente(ClienteDB clienteDB){
        return Cliente
            .builder()
            .id(clienteDB.getId())
            .nome(clienteDB.getNome())
            .cpf(clienteDB.getCpf())
            .email(clienteDB.getEmail())
            .build();
    }

    public static ClienteDB mapClienteDB(Cliente cliente){
        return ClienteDB
            .builder()
            .nome(cliente.getNome())
            .cpf(cliente.getCpf())
            .email(cliente.getEmail())
            .build();
    }
}
