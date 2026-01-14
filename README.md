# 📢 ForumHub API

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange" alt="Java 17" />
  <img src="https://img.shields.io/badge/Spring%20Boot-3.0-brightgreen" alt="Spring Boot 3.0" />
  <img src="https://img.shields.io/badge/MySQL-8.0-blue" alt="MySQL" />
  <img src="https://img.shields.io/badge/Flyway-Enabled-red" alt="Flyway" />
</p>

## 💻 Sobre o Projeto

O **ForumHub** é uma API REST desenvolvida como parte do Challenge Back-end da Alura. O objetivo é replicar o funcionamento interno de um fórum, permitindo a criação, listagem, atualização e exclusão de tópicos, além de gerenciar a autenticação de usuários de forma segura e stateless.

O projeto segue as melhores práticas de desenvolvimento com **Spring Boot**, utilizando migrações de banco de dados, validações de regras de negócio e segurança via tokens JWT.

## ⚙️ Funcionalidades

- **Autenticação e Autorização**:
  - Login de usuários (retorna Token JWT).
  - Bloqueio de rotas para usuários não autenticados.
- **Gestão de Tópicos (CRUD)**:
  - Criação de novos tópicos (vinculados ao usuário logado).
  - Listagem de tópicos com paginação.
  - Detalhamento de um tópico específico.
  - Atualização de dados (Título e Mensagem).
  - Exclusão de tópicos.

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3** (Web, Data JPA, Validation, Security)
- **MySQL** (Banco de dados)
- **Flyway** (Gerenciamento de Migrations)
- **Lombok** (Redução de código boilerplate)
- **Auth0 java-jwt** (Geração e validação de tokens)
- **Maven** (Gerenciador de dependências)

## 📂 Estrutura do Projeto

A organização do código foi pensada para manter a clareza, separando as configurações de segurança das regras de negócio (Tópicos e Usuários):

```text
src/main/java/com/forumhub/yudi
│
├── controller       # Endpoints da API (TopicoController, AutenticacaoController)
├── repository       # Interfaces de comunicação com o Banco de Dados
├── security         # Configurações de Segurança, Filtros e Token Service
├── topico           # Regras de negócio, Entidade e DTOs de Tópicos
├── usuario          # Regras de negócio, Entidade e DTOs de Usuários
└── ForumApplication.java
```

## 🚀 Como Executar

### Pré-requisitos
- Java 17 instalado.
- Maven instalado.
- MySQL rodando localmente.

### Passo a Passo

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/OyudiF/ForumHub.git](https://github.com/OyudiF/ForumHub.git)
   ```
2. **Configure o Banco de Dados:**
  -Crie um banco de dados no MySQL chamado forumhub_api.
  -No arquivo `src/main/resources/application.yml`, configure suas credenciais:
     ```yaml
     spring:
       datasource:
         url: jdbc:mysql://localhost:3306/forumhub_api
         username: SEU_USUARIO
         password: SUA_SENHA
     
     # Configuração do Token JWT
     api:
       security:
         token:
           secret: SUA_CHAVE_SECRETA_AQUI
     ```

3. **Execute a aplicação:**
   - **Via IDE:** Execute a classe `ForumApplication.java`.
   - **Via Terminal:**
     ```bash
     mvn spring-boot:run
     ```

## 📍 Endpoints da API

Aqui estão os principais endpoints para teste no Postman ou Insomnia:

| Método | Rota | Descrição | Auth |
|---|---|---|---|
| `POST` | `/login` | Autentica o usuário e retorna o Token JWT. | ❌ |
| `GET` | `/topicos` | Lista todos os tópicos (paginado). | ❌ |
| `GET` | `/topicos/{id}` | Detalha um tópico específico. | ✅ |
| `POST` | `/topicos` | Cria um novo tópico. | ✅ |
| `PUT` | `/topicos` | Atualiza um tópico existente. | ✅ |
| `DELETE`| `/topicos/{id}` | Exclui um tópico. | ✅ |

> **Nota:** Para as rotas com Auth ✅, é necessário enviar o cabeçalho `Authorization` com o valor `Bearer <seu_token>`.

## 👨‍💻 Autor

Desenvolvido por **Yudi** como parte do desafio Back-end da Alura.
