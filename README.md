# fiap-gastro-reserva
Projeto apresentado como requisito para conclusão da fase 01 do curso Arquitetura e desenvolvimento em Java, da Faculdade Fiap.    


# O sistema a composto por:

    backend: Em java e spring onde foi implementado toda a lógica de negócio, utilizamos alguns padrões de projeto como: 

    MVC onde o projeto é dividido em três camadas: a camada de interação do usuário (view), a camada de manipulação dos dados (model) e a camada de controle (controller). 

    Repository para abstrair a camada de acesso ao banco de dados. 

    DTO (Data Transfer Object) padrão voltado para transferência de dados entre camadas de aplicação. 

    Banco de dados H2: para armazenar as informações rodando em memória  

    Flyway :É um framework que permite o versionamento e gerenciamento do Banco de Dados de maneira mais segura e automatizada 

    Lombok: Que é uma biblioteca que permite deixar o código mais limpo reduzindo o boilerplate por meio de anotações. 