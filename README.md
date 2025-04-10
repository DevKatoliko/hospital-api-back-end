# hospital-api-back-end
Esse é um projeto de uma API Web para gerenciamento hospitalar.
Estou fazendo uso das tecnologias, frameworks e padrões de projeto:
- Java 21
- DTO (Data Transfer Object)
- DAO (Data Access Object)
- MVC (Model View Controller)
- Spring Boot
- Spring Security
- Firebase Authentication
- JPA / Hibernate
- Bean Validation (Jakarta)
- RESTful API
- Maven

## 🔐 Funcionalidades

### 📌 Autenticação

- Integração com Firebase Authentication
- Controle de acesso por perfis: `ADM`, `DOCTOR`, `PATIENT`
- Segurança com `@PreAuthorize` baseada em roles

### 👤 Usuários

- Cadastro de Pacientes (aberto)
- Cadastro de Médicos e Administradores (restrito a administradores)
- Alteração de senha (usuário autenticado)
- Exclusão de conta (usuário autenticado)
- Obtenção de dados do usuário autenticado

  ## ⚙️ Status

- As principais funcionalidades de autenticação e gestão de usuários estão implementadas.
- Testes automatizados e outras features serão adicionadas futuramente.

## 🎯 Objetivo

Este projeto foi criado com fins didáticos e para compor meu portfólio como desenvolvedor Java backend.  
Ele representa o início da construção de um sistema hospitalar completo, com foco em segurança, boas práticas e escalabilidade.

## 👤 Autor

**Rubens**  
Estudante de Análise e Desenvolvimento de Sistemas | Desenvolvedor Java Backend
