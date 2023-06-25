CREATE TABLE medicos(

    id BIGINT not NULL auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    telefone varchar(20) not null,
    crm varchar(6) not null unique,
    especialidade varchar(50) not null,
    logradouro varchar(100) not null,
    bairro varchar(50) not null,
    cep varchar(10) not null,
    cidade varchar(50) not null,
    uf varchar(2) not null,
    numero varchar(10) not null,
    complemento varchar(20) not null,

    primary key(id)

);