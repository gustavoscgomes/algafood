# Curso Especialista Spring REST

Este repositório contém o código e os recursos do projeto desenvolvido durante o curso "Especialista Spring REST". O curso abrange uma ampla gama de tópicos essenciais para o desenvolvimento de APIs RESTful com o ecossistema Spring. Abaixo está um resumo dos principais tópicos abordados no curso.

## Conteúdo do Curso

### Spring e Injeção de Dependências
- Ecossistema Spring (Spring Framework, Spring MVC, Spring Boot, Spring Data JPA, Spring Security, Spring Security OAuth, Spring HATEOAS)
- Injeção de dependências com Spring (IoC Container, @Component, @Configuration, @Bean, @Primary, @Qualifier)
- Spring Profiles, eventos customizados, configuração com application.properties, propriedades customizadas com @Value e @ConfigurationProperties

### JPA, Hibernate e Flyway
- ORM e mapeamento de entidades e relacionamentos (OneToMany, ManyToOne, ManyToMany, OneToOne, Embedded)
- Transações no Spring, JPQL, Criteria, joins, fetch, pool de conexões (Hikari)
- Evolução de schema de banco de dados com Flyway, migrações, dados de testes, uso de Lombok

### Spring Data JPA
- Criação de repositórios inteligentes com Spring Data JPA, query methods, paginação, ordenação, parâmetros nomeados
- Implementação de repositórios customizados, externalização de consultas JPQL, consultas com Specifications (DDD)

### Domain-Driven Design (DDD)
- Conceitos e padrões do DDD (Repository, Aggregate, Aggregate Root, Domain Event, Domain Service, Infrastructure Service, Specification, Linguagem Ubíqua)

### Fundamentos Avançados de REST com Spring
- Arquitetura REST, constraints, API, Resource, Resource Model, Resource Representation, Resource Identifier, Resource Methods
- Modelo de Maturidade de Richardson, abordagem pragmática e purista de REST APIs
- HTTP, códigos de status, métodos seguros e idempotentes, criação e configuração de API do zero

### Validações com Bean Validation
- Adição de validações no modelo com Bean Validation, customização de mensagens, validações compostas e customizadas, validações em cascata

### Tratamento e Modelagem de Erros da API
- Tratamento de exceptions, uso de @ResponseStatus, @ExceptionHandler, ResponseStatusException, @ControllerAdvice, ResponseEntityExceptionHandler
- Modelagem de erros seguindo a RFC 7807

### Testes de Integração
- Implementação de testes de integração automatizados com Spring Boot Test, REST Assured, JUnit, AssertJ, Maven Failsafe Plugin
- Limpeza e população de dados de testes

### Boas Práticas e Modelagem Avançada de APIs
- Leis fundamentais para trabalhar com data/hora em APIs, customizações de Jackson, nomeação de URIs, modelagem de recursos
- Modelagem de projeções, pesquisas complexas, relatórios, serializador customizado do Jackson

### Upload e Download de Arquivos
- Modelagem de recursos para upload de imagens e documentos, armazenamento no servidor ou Amazon S3
- Implementação de download de arquivos

### Envio de E-mails Transacionais
- Montagem de templates de e-mails com Apache FreeMarker, envio de e-mails fake e sandbox

### Cache de HTTP
- Implementação de HTTP Caching com Cache-Control, ETags, requisições condicionais

### Documentação com OpenAPI (Swagger)
- Geração de documentação com OpenAPI/Swagger, uso de SpringFox, Swagger UI, manutenção da consistência da documentação

### HATEOAS e Discoverability
- Adição de hypermedia nas representações dos recursos, uso de Spring HATEOAS, especificação HAL

### CORS e Consumo das APIs com Java e JavaScript
- Consumo de API com Java e JavaScript, habilitação de CORS na API

### Segurança com Spring Security, OAuth2 e JWT
- Implementação de autenticação básica HTTP, OAuth2, Resource Server, Authorization Server, diferentes fluxos de autorização
- Uso de access tokens, refresh tokens, PKCE, Opaque Tokens, Transparent Tokens (JWT), Method Security, Spring Expression Language (SpEL)
- Controle de segurança contextual, inclusão de links de acordo com as permissões do usuário

### Cloud-native APIs
- Desenvolvimento e implantação de APIs cloud-native

### Dockerização da Aplicação
- Configuração e uso de Docker, escalabilidade, uso de Docker Compose

### Deploy em Produção na Nuvem da Amazon
- Deploy na AWS usando Elastic Container Service (ECS), Fargate, Amazon Elastic Container Registry (ECR), MySQL com Amazon RDS, Redis, Amazon Elastic Load Balancer (ELB)


### Requerimento
1. Java 11
2. Spring Tool Suite 4 (IDE utilizada)
3. Docker
4. Client Mysql - consultar os dados (Mysql Workbench, utilizado)
5. Postman

## Diagrama do Projeto
![Diagrama de Classes](https://github.com/gustavoscgomes/algafood/blob/main/image/Conteudo%20do%20treinamento%20Projeto.jpg?raw=true)

> Status do Projeto: Em desenvolvimento :warning:
