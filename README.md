# Desafio Técnico

O projeto possui o arquivo postman para testar os serviços disponibilizados pela API. Além disso, dentro do projeto existe um arquivo chamado docker-compose.yml que representa um orquestrador responsável por subir os containers necessários para rodar a aplicação localmente. Dentro do orquestrador existem os containers relativos ao banco de dados e ao serviço de mensageria.

Para executar o orquestrador:

  * Instale o docker;
  * Na raiz do projeto, use o comando: docker-compose up para instalar as imagens do postgres e do rabbitMq.

Links:
  * Servidor: https://projeto-tecnico-south-system.herokuapp.com/
  * Swagger: https://projeto-tecnico-south-system.herokuapp.com/swagger-ui.html#

Tecnologias utilizadas:

  * Java e SpringBoot
  * Mensageria - RabbitMQ
  * Heroku  - Servidor na nuvem
  * PostgresSql - banco de dados
  * Swagger - Documentação de API
  * Git  - Versionamento utilizando gitflow
  * JUNIT/Mockito - Testes unitários
  * Docker - Containers
  * log4j - Logs

## Objetivo

Desenvolver uma REST API que:

* Permita criação de novos clientes;

* Permita a atualização de clientes existentes;

* Permita que seja possível listar os clientes de forma paginada;

* Permita que buscas por atributos cadastrais do cliente;

* É necessário também que cada elemento retornado pela api de clientes informe a idade;

* Documente sua API e também disponibilize um arquivo Postman para fácil utilização da API.


## Critérios

Utilização de boas práticas de código;

Utilização de padrões de projeto;

Cobertura de testes (Unitários, Integrados e/ou de comportamento);

Design de API REST.



### Tarefas bônus

Empacote sua aplicação com Docker;

Forneça outros itens de infraestrutura em containers (Banco de Dados, Cache, etc);

Utilize um orquestrador de container (Ex. Docker Compose);

Hospede o projeto em algum provedor cloud e forneça por email a URL para acesso.


## Notas

A arquitetura da aplicação foi definida como uma arquitetura em três camadas: Resource, Repository e Service. Dessa forma, cada camada possui sua responsabilidade.
No desenvolvimento de cada camada foram usados os princípios da orientação a objetos definidos pelo SOLID. Todas as classes prezam pela responsabilidade unica. Para cada serviço foi criado um cenário de teste com JUNIT.

