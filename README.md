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

# Como Utilizar o Postman para Testar a API

## Passos para Configurar o Postman

#### 1. Instalar o Postman

Se você ainda não tem o Postman instalado, faça o download e instale-o no seu computador a partir de https://www.postman.com/downloads/

#### 2. Criar uma Nova Requisição

1. Abra o **Postman**.
2. Clique no botão **New** no canto superior esquerdo e selecione **Request**.
3. Na janela que aparecer, escolha um nome para a requisição, adicione uma descrição se necessário, e clique em **Save**.

## Testando a API com o Postman

#### **1. Listar Agendamentos**

- **Método HTTP**: `GET`
- **URL**: `http://localhost:8080/scheduling`

1. No Postman, selecione o método `GET`.
2. Insira a URL `http://localhost:8080/scheduling`.
3. Clique em **Send**.
4. O Postman deve retornar uma lista de todos os agendamentos cadastrados.

#### **2. Obter um Agendamento Específico**

- **Método HTTP**: `GET`
- **URL**: `http://localhost:8080/scheduling/{id}`

1. No Postman, selecione o método `GET`.
2. Substitua `{id}` pela ID do agendamento que deseja consultar. Exemplo: `http://localhost:8080/scheduling/1`.
3. Clique em **Send**.
4. O Postman deve retornar os dados do agendamento com o ID informado.

#### **3. Criar um Novo Agendamento**

- **Método HTTP**: `POST`
- **URL**: `http://localhost:8080/scheduling`
- **Body**: JSON

1. No Postman, selecione o método `POST`.
2. Insira a URL `http://localhost:8080/scheduling`.
3. Vá para a aba **Body** e selecione a opção **raw**.
4. No campo de texto, insira o JSON com as informações do agendamento, como o exemplo abaixo:

```json
{
    "client": {"name": "João",
    "email": "joao@example.com",
    "phone": "(11) 98765-4321"
    },
    "date": "2024-12-01",
    "time": "10:00",
    "service": "Tatuagem",
    "price": 200.00
}
```

## Atualizar um Client:

1. No Postman, selecione o método `PUT`.
2. Na URL `http://localhost:8080/scheduling` insira o id do cliente que será atualizado:
`http://localhost:8080/scheduling/1`
3. Vá para a aba **Body** e selecione a opção **raw**.
4. No campo de texto, insira o JSON com as informações a serem atualizadas, como o exemplo abaixo:
```
{
    "client": {
    "name": "Carlos Ronaldo", 
    "email": "carlos.ronaldo@example.com", 
    "phone": "(11) 98765-4567"
    },
    "date": "2025-06-10",
    "time": "13:00",
    "service": "Piercing",
    "price": 60.00
}
```
e clique en SEND. O Postman deve retornar a confirmação de que o agendamento foi atualizado.

## Deletar um Client:
1. No Postman, selecione o método `DELETE`.
2. Na URL insira `http://localhost:8080/scheduling/{id}` subistituindo {id} pelo numero desejado.
3. Clique em SEND e o Postman deve retornar uma confirmação de que o agendamento foi deletado.

