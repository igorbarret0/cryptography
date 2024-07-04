<h1 align="center">
  Criptografia Desafio
</h1>

Este projeto consiste na criptografia de dados sensivéis no cadastro de usuários utilizando o algoritmo de hash SHA512
## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [MySQL](https://www.mysql.com/)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Java Security](https://docs.oracle.com/javase/8/docs/technotes/guides/security/)



## Como Executar

- Clonar repositório git
```
git clone git@github.com:igorbarret0/cryptography.git
```

- Construir o projeto:
```
./mvnw clean package
```


A API poderá ser acessada em [localhost:8080](http://localhost:8080).

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [Postman](https://www.postman.com/)

-  USER 
```
POST /user - Salvar usuário 

{
    "userDocument": "userDocument",
    "creditCardToken": "creditCardToken",
    "value": 900.0
}

```

```
PUT /user - Atualizar usuário 

{
    "id": 10,
    "userDocument": "userDocument",
    "creditCardToken": "creditCardToken",
    "value": 900.0
}

```

```
GET /user/{id} - Encontrar usuário pelo Id 

```

```
DELETE /user/{id} - Deletar usuário pelo Id 

```



