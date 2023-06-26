create table pacientes(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    telefone varchar(20) not null,
    email varchar(100) not null,
    cpf varchar(15) not null,
    logradouro varchar(100) not null,
    bairro varchar(50) not null,
    cep varchar(10) not null,
    cidade varchar(50) not null,
    uf varchar(2) not null,
    numero varchar(10) not null,
    complemento varchar(20) not null,

    primary key(id)
);