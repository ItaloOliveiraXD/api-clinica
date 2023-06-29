CREATE TABLE usuarios(

    id BIGINT not NULL auto_increment,
    login varchar(100) not null,
    senha varchar(255) not null,

    primary key(id)
);