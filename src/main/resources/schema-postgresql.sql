CREATE TABLE IF NOT EXISTS clientes (
     id serial PRIMARY KEY,
     nome  varchar(50),
     email varchar(50),
     telefone varchar(50),
     nascimento varchar(50)
);

CREATE TABLE IF NOT EXISTS tarefas (
     id serial PRIMARY KEY,
     nome  varchar(50),
     responsavel varchar(50),
     inicio varchar(50),
     termino varchar(50)
);

CREATE TABLE IF NOT EXISTS produtos (
     id serial PRIMARY KEY,
     nome  varchar(50),
     descricao varchar(255),
     preco varchar(50),
     estoque varchar(50)
);

CREATE TABLE IF NOT EXISTS relatorios (
     id serial PRIMARY KEY,
     assunto  varchar(50),
     responsavel varchar(255),
     descricao varchar(255),
     dtrelatorio varchar(50)
);