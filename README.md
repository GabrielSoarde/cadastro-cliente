# Sistema de Cadastro de Clientes

Este é um sistema de cadastro de clientes desenvolvido em Java com **Spring Boot**, utilizando **PostgreSQL** como banco de dados e integração com envio de e-mails.

## Funcionalidades

- **Adicionar clientes com os dados**: *Nome, E-mail e Telefone.*
- **Listar todos os clientes cadastrados**.
- **Buscar cliente por ID.**
- **Atualizar cliente por ID**
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



## Dependências
As principais dependências estão listadas no **pom.xml**. Não esqueça de rodar o maven para baixar as dependências.

     mvn clean install

# Rodando o Projeto

1. Clone este repositório:
 
        git clone https://github.com/GabrielSoarde/cadastro-cliente.git
        cd cadastro-cliente
2. Configure o banco de dados no arquivo **application.properties**
3. Configure as variáveis de ambiente:
   
- Abra o terminal (CMD) e digite:

      $env:SPRING_MAIL_USERNAME="SEU EMAIL"
      $env:SPRING_MAIL_PASSWORD="SUA SENHA"
  
- Para verificar se está tudo correto, digite no terminal (CMD):

      echo $env:SPRING_MAIL_USERNAME
      echo $env:SPRING_MAIL_PASSWORD
  
5. Compile e execute o projeto:
   
        mvn spring-boot:run
   
7. Acesse o sistema utilizando um navegador:

        http://localhost:8080

**OBS:** *Você pode utilizar o próprio terminal da sua IDE*    
   
# Endpoints da API

- **POST /clients**: Adiciona um novo cliente.
- **GET /clients**: Lista todos os clientes.
- **GET /clients/{id}**: Busca clientes pelo id.
- **PUT /clients/{id}**: Atualiza os dados de um cliente pelo id.
- **DELETE /cliets/{id}**: Exclui o cliente pelo id.
- **POST /clients/send-email**: Envia um email para um cliente.


