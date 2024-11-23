# Sistema de Cadastro de Clientes

Este é um sistema de cadastro de clientes desenvolvido em Java com **Spring Boot**, utilizando **PostgreSQL** como banco de dados e integração com envio de e-mails.

## Funcionalidades

- **Adicionar clientes com os dados**: Nome, E-mail e Telefone.
- **Listar todos os clientes cadastrados**.
- **Buscar cliente por ID.**
- **Excluir cliente por ID.**
- **Enviar e-mails personalizados.**

## Tecnologias Utilizadas

- **Java (Spring Boot)**
- **PostgreSQL (Banco de dados)**
- **Thymeleaf (Interface HTML dinâmica)**
- **Jakarta Mail (Envio de e-mails)**
- **HTML e JavaScript (Front-end simples)**
- **Hibernate/JPA (Persistência de dados)**
  
## Pré-requisitos
Certifique-se de ter os seguintes softwares instalados:

- **Java 17 ou superior**
- **PostgreSQL**
- **Maven**
- **Uma conta de e-mail para configuração do envio de mensagens**
  
## Configuração
### Banco de Dados
1. Crie um banco de dados **PostgreSQL** com o nome **clients**:
   
       CREATE DATABASE clients;

2. Configure as credenciais no arquivo `application.properties`:

        spring.datasource.url=jdbc:postgresql://localhost:5432/clients
        spring.datasource.username=SEU_USUARIO
        spring.datasource.password=SUA_SENHA
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.show-sql=true

## Configuração de E-mail
No mesmo arquivo `application.properties`, configre os dados de um serviço **SMTP**:

    spring.mail.host=smtp.gmail.com
    spring.mail.port=587
    spring.mail.username=SEU_EMAIL
    spring.mail.password=SUA_SENHA
    spring.mail.properties.mail.smtp.auth=true
    spring.mail.properties.mail.smtp.starttls.enable=true
    
⚠️ **Não deixe credenciais sensíveis diretamente no arquivo. Utilize variáveis de ambiente!**

## Dependências
As principais dependências estão listadas no **pom.xml**. Não esqueça de rodar o maven para baixar as dependências.

     mvn clean install

# Rodando o Projeto

1. Clone este repositório:
 
        git clone https://github.com/GabrielSoarde/cadastro-cliente.git
        cd cadastro-cliente
2. Configure o banco de dados e o e-mail no arquivo **application.properties**
3. Compile e execute o projeto:
   
        mvn spring-bot:run
4. Acesse o sistema utilizando um navegador:

        http://localhost:8080
   
# Endpoints da API

- **POST /clients**: Adiciona um novo cliente.
- **GET /clients**: Lista todos os clientes.
- **GET /clients/{id}**: Busca clientes pelo id.
- **DELETE /cliets/{id}**: Exclui o cliente pelo id.
- **POST /clients/send-email**: Envia um email para um cliente.
