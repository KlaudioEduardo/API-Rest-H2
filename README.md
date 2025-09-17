# API-Rest-H2[README (1).md](https://github.com/user-attachments/files/22390853/README.1.md)

# **Livraria API** 📚  

Uma API REST que realiza operações CRUD em uma livraria.  
Permite **criar, listar, atualizar e deletar livros**, além de associá-los a **autores**.

---

## **Instalação** ⚙️  

Antes de começar, certifique-se de ter os seguintes pré-requisitos instalados:  
- [Java 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)  
- [Maven](https://maven.apache.org/)  
- [Postman](https://www.postman.com/) (opcional, para testes)  

Clone o projeto em sua máquina:
```bash
git clone https://github.com/KlaudioEduardo/API-Rest-H2.git
```

Entre na pasta do projeto:
```bash
cd Livraria-API
```

---

## **Estrutura do Projeto** 🗂️  

Diagrama representando o relacionamento entre **Livro** e **Autor**:

```
Livro (N)  <----->  (1) Autor
```

| Livro        | Autor        |
|--------------|--------------|
| id: Long     | id: Long     |
| nome: String | nome: String |
| autor: Autor | livros: List |

---

## **Endpoints da API** 🌐  

### **1. Listar todos os livros**  
`GET /livros`  
**Descrição:** Retorna todos os livros cadastrados.

---

### **2. Buscar livro por ID**  
`GET /livros/{id}`  
**Parâmetro:**  
| Nome | Tipo  | Descrição                  |
|------|-------|---------------------------|
| id   | Long  | ID do livro a ser buscado |

---

### **3. Adicionar novo livro**  
`POST /livros`  
**Descrição:** Envia os dados do livro no formato JSON.  

Exemplo de corpo da requisição:
```json
{
  "nome": "Nome do Livro"
}
```

---

### **4. Deletar um livro**  
`DELETE /livros/{id}`  
**Parâmetro:**  
| Nome | Tipo  | Descrição                  |
|------|-------|---------------------------|
| id   | Long  | ID do livro a ser deletado |

---

### **5. Atualizar um livro**  
`PUT /livros/{id}`  
**Parâmetro:**  
| Nome | Tipo  | Descrição                  |
|------|-------|---------------------------|
| id   | Long  | ID do livro a ser atualizado |

Exemplo de corpo da requisição:
```json
{
  "nome": "Novo Nome do Livro"
}
```

---

## **Tecnologias Utilizadas** 🛠️  

Este projeto foi desenvolvido com as seguintes tecnologias:

- **Java 21**  
- **Spring Boot**  
- **Spring Data JPA**  
- **H2 Database** (banco de dados em memória)  
- **Postman** (para testes)

---

## **Como Executar o Projeto** 🚀  

No terminal, execute o comando abaixo:

```bash
mvn spring-boot:run
```

Após iniciar, a API estará disponível em:  
```
http://localhost:8080
```
