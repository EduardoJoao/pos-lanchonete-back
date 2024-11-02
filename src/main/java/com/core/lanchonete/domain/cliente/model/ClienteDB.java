package com.core.lanchonete.domain.cliente.model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tb_cliente")
public class ClienteDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "cpf")
    private String cpf;
}
