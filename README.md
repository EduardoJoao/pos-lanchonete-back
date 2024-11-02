# Projeto de Lanchonete - Sistema de Controle de Pedidos

## Descrição do Projeto

Este projeto implementa um **Sistema de Controle de Pedidos para uma Lanchonete** em expansão, buscando melhorar a organização e eficiência no atendimento ao cliente. A aplicação é desenvolvida com arquitetura de backend monolítica, utilizando Spring Boot e JPA para facilitar o gerenciamento dos pedidos, produtos e clientes, além de realizar a persistência no banco de dados. O sistema inclui uma documentação Swagger para facilitar o consumo da API.

## Objetivos do Projeto

O objetivo deste projeto é criar uma solução de autoatendimento para a lanchonete, que inclua as principais funcionalidades de controle e organização de pedidos, permitindo ao estabelecimento expandir sua operação com um serviço eficiente e ágil. Especificamente, os objetivos são:

1. **Gerenciamento de Pedidos e Produtos**: Facilitar a criação, edição, listagem e remoção de produtos, além do processamento de pedidos, permitindo que o cliente monte combos personalizados e acompanhe o status do pedido.
2. **Controle e Organização dos Pedidos**: Enviar pedidos para a cozinha de forma organizada, atualizando o status conforme avançam no processo de preparo até a retirada.
4. **Gestão de Clientes e Promoções**: Registrar clientes para futuras campanhas promocionais e melhorias no relacionamento com o cliente.
5. **Documentação e Infraestrutura Pronta**: Os arquivos `Dockerfile` e `docker-compose.yml` estão na raiz do projeto para facilitar o teste do projeto.

## Funcionalidades

- **Cadastro de Clientes**: API para criar e identificar clientes via CPF.
- **Gerenciamento de Produtos**: CRUD completo para produtos, permitindo buscar produtos por categoria e editar/remover produtos existentes.
- **Gerenciamento de Pedidos**: Criação e listagem de pedidos, além do controle de status (Recebido, Em preparação, Pronto e Finalizado).
- **Pagamento via QR Code**: Mockado em uma classe.
- **Monitoramento de Pedidos**: Atualização e exibição do status do pedido em tempo real.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot** com **Spring Data JPA**
- **Banco de Dados**: PostgreSQL
- **Swagger**: Documentação da API
- **Docker e Docker Compose**: Configuração de ambiente para fácil execução

## Como Executar o Projeto

1. Clone o repositório.
2. Comandos na sequência  `docker build -t lanchonete-1:latest .` e rodar o comando `docker-compose up`.
3. Acesse a documentação da API via Swagger em `http://localhost:8080/swagger-ui.html`.
