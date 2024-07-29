# Fiap-Venda Veiculo

[![Java CI/CD with Spring Boot](https://github.com/RoAlencar/Fiap-Venda_Veiculo/actions/workflows/deploy.yml/badge.svg)](https://github.com/RoAlencar/Fiap-Venda_Veiculo/actions/workflows/deploy.yml)
## 💬 Sobre o repositório

O Venda Veiculo  consiste em um sistema que é utilizado em uma empresa de revenda de veículos automotores, que disponibiliza uma plataforma para cadastro, vendas, gerenciamento e pagamento de veículos.

## ⚠ Pré-requisitos para execução do projeto

* Java 21
* Maven
* PostgreSQL

## 📌 Como utilizar?

Para utilizar o Venda Veiculo, é necessário ter uma instância de conexão do banco de dados ativa (no caso PostgreSQL), que por padrão fica na porta 5432, caso sua porta esteja diferente, especifique no application.properties em:

```
spring.datasource.url=jdbc:postgresql://localhost:<PORTA_BD>/fiap_car_sales_db
spring.datasource.username=<USUARIO_BD>
spring.datasource.password=<SENHA_BD>
```

Com o banco de dados devidamente configurado, rode a aplicação através do seguinte comando:

*Disponível em http://localhost:8081/

```
mvn spring-boot:run 
```

Com a aplicação rodando, acesse o localhost (porta 8081), e usufrua do sistema!

## Documentação 📒
A documentação da API pode ser acessada em:

[Swagger - Local](http://localhost:8080/swagger-ui/index.html)

## Postman Collections

As collections para teste local e no Heroku podem ser baixadas em:
* [Collections - Local](https://drive.google.com/file/d/1PodDm_tabSR9AL5spxQ0Blvd71S0QU9y/view?usp=sharing)
* [Collections - Heroku ](https://drive.google.com/file/d/1Nq33H52cxHj1VMvGtk-MCzQNRUrEmBrF/view?usp=sharing)

### Entregas do projeto
- [x] Listagem de veículos para venda
- [x] Listagem de veículos vendidos
- [x] Listagem de todas as vendas
- [x] Venda de veículo
- [x] Reserva de veículo
- [x] Webhook de consulta status de pagamento

### CI/CD
- [x] Implementar Github Actions
- [x] Cobertura de testes unitários acima de 80%
- [x] Deploy no Heroku

### Infraestrutura
- [x] Cluster Heroku
- [x] Objetos do kubernetes (Deployment, Service, Ingress).
- [x] Banco de dados PostgreSQL no Heroku

# Evidências

### Cobertura de testes
![image](/images/evidenciaCobertura.png)

## Documentação da API
![image](/images/swagger.png)

## CI/CD
![image](/images/githubActions.png)

### Deploy K8s (Heroku)
![image](/images/dashboardHeroku.png)

### Evidencias dos recursos criados no Heroku
![image](/images/evidenciasRecursosHeroku.png)

### Desenho da arquitetura Hexagonal
![image](/images/arquiteturaHexagonal.png)

### Banco de dados (Postgres)
![image](/images/bancoPostgres.png)

