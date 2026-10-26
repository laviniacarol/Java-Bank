<h1>API REST de um banco simplificado, feita em Java e Spring Boot para estudo e portfólio.</h1>
<br>
<line></line>
<br>
Project that simulates banking operations: payment systems and bank transactions
<br>
<b>Stack: Java 17, Spring Boot, Spring Data JPA/Hibernate, PostgreSQL (em container Docker), Maven</b>
The CPF must be sent as 11 digits, without dots or dashes.

## Error responses

Errors are returned as JSON with the HTTP status and a message:

```json
{
  "timestamp": "2026-10-26T20:10:00.123",
  "status": 400,
  "message": "Dados inválidos",
  "fields": {
    "email": "E-mail inválido"
  }
}
```

The `fields` object lists which fields failed validation. For other errors it is empty. The error messages are currently written in Portuguese.

| Status | When it happens |
|---|---|
| 400 | Invalid data, malformed JSON or a parameter of the wrong type |
| 404 | Customer not found |
| 409 | CPF or e-mail already registered |
