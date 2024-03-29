# Person API

## Sistema de Gerenciamento de Pessoas com deploy no Heroku, curso da DIO

Nesta live coding vamos desenvolver um pequeno sistema para o gerenciamento de pessoas de uma empresa através de uma API REST, criada com o Spring Boot.

Durante a sessão, serão desenvolvidos e abordados os seguintes tópicos:

- Setup inicial de projeto com o Spring Boot Initialzr;
- Criação de modelo de dados para o mapeamento de entidades em banco de dados;
- Desenvolvimento de operações de gerenciamento de usuários (Cadastro, leitura, atualização e remoção de pessoas de um sistema);
- Relação de cada uma das operações acima com o padrão arquitetural REST e a explicação de cada um dos conceitos REST envolvidos durante o desenvolvimento do projeto;
- Desenvolvimento de testes unitários para validação das funcionalidades;
- Implantação do sistema na nuvem através do Heroku.

Para executar o projeto no terminal, digite o seguinte comando:

```
gradle bootRun
```

Após executar o comando acima, basta apenas abrir o seguinte endereco e visualizar a execução do projeto:

```
http://localhost:8080/api/v1/people
```

Para execução no Heroku, acessas o seguinte endereço:

```
http://peopleapi-leilafarias.herokuapp.com
```