# ToDo Application

Este é um projeto de uma API para gerenciar uma lista de tarefas (ToDo List) desenvolvido em **Spring Boot**. A API permite criar, listar e marcar tarefas como concluídas, utilizando um arquivo JSON como banco de dados.

## Requisitos

- **Java 11** ou superior
- **Maven**
- **Docker** (para execução em container)
- **Postman** ou **cURL** (para testar as rotas)

## Funcionalidades

- **Adicionar uma tarefa**: Criar uma nova tarefa com uma descrição.
- **Listar tarefas**: Listar todas as tarefas, tanto as pendentes quanto as concluídas.
- **Marcar tarefa como concluída**: Atualizar o status de uma tarefa como concluída.
- **Rota Sobre**: Exibir informações sobre o autor e o projeto.

## Como Executar

### Localmente

1. Clone o repositório:

   ```bash
   git clone https://github.com/NicolasFreitas1/todo-application.git
   ```

2. Navegue até o diretório do projeto:

   ```bash
   cd todo-application
   ```

3. No arquivo **TodoService** altere a variável **FILE_PATH** para:

   ```java
    private static final String FILE_PATH = "src/main/resources/tasks.json";
   ```

4. Compile e execute o projeto:

   ```bash
   ./mvnw spring-boot:run
   ```

5. A API estará disponível em: `http://localhost:8080`

### Usando Docker

1. Construa a imagem Docker:

   ```bash
   docker-compose up --build
   ```

2. Inicie o container docker:

   ```bash
   docker-compose up -d
   ```

3. A API será executada automaticamente no endereço: `http://localhost:8080`.

## Rotas da API

### 1. **Listar todas as tarefas**

- **Método**: `GET`
- **Rota**: `/todos`
- **Descrição**: Retorna uma lista de todas as tarefas.
- **Exemplo de Resposta**:
  ```json
  [
    {
      "id": 1,
      "description": "Desenvolver rotas para cadastro e edição de produtos",
      "completed": false
    },
    {
      "id": 2,
      "description": "Desenvolver autenticação do usuário",
      "completed": true
    }
  ]
  ```

### 2. **Criar uma nova tarefa**

- **Método**: `POST`
- **Rota**: `/todos`
- **Descrição**: Adiciona uma nova tarefa.
- **Exemplo de Requisição**:
  ```json
  {
    "description": "Nova tarefa a ser feita"
  }
  ```
- **Exemplo de Resposta**:
  ```json
  {
    "id": 3,
    "description": "Nova tarefa a ser feita",
    "completed": false
  }
  ```

### 3. **Marcar tarefa como concluída**

- **Método**: `PATCH`
- **Rota**: `/todos/{id}/complete`
- **Descrição**: Atualiza o status de uma tarefa para concluída.
- **Exemplo de Requisição**:
  - URL: `http://localhost:8080/todos/1/complete`
- **Exemplo de Resposta**:
  ```json
  {
    "id": 1,
    "description": "Estudar Spring Boot",
    "completed": true
  }
  ```

### 4. **Rota Sobre**

- **Método**: `GET`
- **Rota**: `/sobre`
- **Descrição**: Exibe informações sobre o estudante e o projeto.
- **Exemplo de Resposta**:
  ```json
  {
    "estudante": "Nicolas Andrade de Freitas",
    "projeto": "Lista de tarefas"
  }
  ```

## Estrutura do Projeto

```bash
src
└── main
    ├── java
    │   └── com
    │       └── exemplo
    │           └── todo
    │               ├── TodoApplication.java
    │               ├── controllers
    │               │   ├── AboutController.java
    │               │   └── TodoController.java
    │               ├── models
    │               │   └── Task.java
    │               └── services
    │                   └── TodoService.java
    └── resources
        └── tasks.json  # Arquivo JSON para armazenar as tarefas
```
