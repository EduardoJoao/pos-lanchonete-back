-- Estrutura de tabelas e inserção de dados

CREATE TABLE tb_cliente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255),
    cpf VARCHAR(255)
);

CREATE TABLE tb_produto (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    descricao TEXT,
    preco DOUBLE PRECISION,
    categoria VARCHAR(255) NOT NULL,
    ativo BOOLEAN NOT NULL
);

CREATE TABLE tb_pedido (
    id SERIAL PRIMARY KEY,
    cliente_id BIGINT,
    status_pedido VARCHAR(255),
    status_pagamento VARCHAR(255),
    total DOUBLE PRECISION,
    FOREIGN KEY (cliente_id) REFERENCES tb_cliente(id)
);

CREATE TABLE tb_fila_cozinha (
    id SERIAL PRIMARY KEY,
    pedido_id BIGINT NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES tb_pedido(id)
);

CREATE INDEX cliente_cnpj_index ON tb_cliente(cpf);

-- Inserção de dados

-- Lanches
INSERT INTO tb_produto (nome, descricao, preco, categoria, ativo) VALUES
('Hambúrguer Clássico', 'Pão, carne, queijo e molho especial', 12.50, 'LANCHE', true),
('Sanduíche Natural', 'Pão integral, frango, alface e tomate', 10.00, 'LANCHE', true);

-- Acompanhamentos
INSERT INTO tb_produto (nome, descricao, preco, categoria, ativo) VALUES
('Batata Frita', 'Batatas fritas crocantes', 8.00, 'ACOMPANHAMENTO', true),
('Anéis de Cebola', 'Cebolas empanadas e fritas', 7.50, 'ACOMPANHAMENTO', true);

-- Bebidas
INSERT INTO tb_produto (nome, descricao, preco, categoria, ativo) VALUES
('Refrigerante', 'Refrigerante de cola 350ml', 5.00, 'BEBIDA', true),
('Suco Natural', 'Suco de laranja natural 300ml', 6.50, 'BEBIDA', true);

-- Sobremesas
INSERT INTO tb_produto (nome, descricao, preco, categoria, ativo) VALUES
('Torta de Limão', 'Torta doce com recheio de limão', 7.00, 'SOBREMESA', true),
('Brownie', 'Brownie de chocolate com nozes', 6.00, 'SOBREMESA', true);
