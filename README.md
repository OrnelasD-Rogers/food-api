# Sistema de Pedidos de Comida

### O QUE É

Uma API Rest para entrega de comida.

### OBJETIVO

Demonstrar conceitos de API Rest, SpringBoot, arquitetura de software e diversos conceitos de JPA.

### BIBLIOTECAS DO PROJETO

- Para persistência de dados foi utilizado o SGBD MySql;
- Foi utilizado o [Hibernate](https://hibernate.org) como implementação para o JPA;
- [Lombok](https://projectlombok.org) para diminuir o Boilerplate code;
- Utilizado o [ModelMapper](http://modelmapper.org) para facilitar a aplicação do padrão **DTO**;
- Versionamento do banco de dados feito através do [Flyway](https://flywaydb.org);

### VALIDACOES

Para a validação de dados foi utilizado a especificação [Jakarta Bean Validation](https://beanvalidation.org/2.0/) com a implementação do [Hibernate Validator](http://hibernate.org/validator/);

### TRATAMENTO DE ERROS

Os erros foram tratados utilizando o **ControllerAdvice** do próprio Spring Framework, com a criação de exceptions e mensagens personalizadas para cada tipo de erro. Foi utilizado como norma o **Problem Details for HTTP Apis rfc7807**;

### BANCO DE DADOS

Foi utilizado o MySql 8.0 para esta aplicação mas também é suportado o banco H2 qual está pré configurado.

### TESTES

Os testes foram realizados utilizando [JUnit](https://junit.org/junit5/), [Mockito](https://site.mockito.org) e [Hamcrest](http://hamcrest.org). Os tipos de teste deste projeto são:

- Teste de Integração

------

#### SE VOCÊ CHEGOU ATÉ AQUI

Muito obrigado pela atenção e qualquer dúvida ou sugestão, basta me contactar.

#### SOBRE O AUTOR

Me chamo Vinícius Ornelas de Almeida e estou mergulhando na carreira de desenvolvedor. Quem sabe uma hora a gente não se ajuda?

- **CONTATO**
  - [ornelas95@hotmail.com](mailto:ornelas95@hotmail.com) 
  - [Linkedin](https://www.linkedin.com/in/vinicius-ornelas-587075128/)