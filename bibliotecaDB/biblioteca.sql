CREATE DATABASE biblioteca;

\c biblioteca;

DROP TABLE IF EXISTS autor CASCADE;
DROP TABLE IF EXISTS livro_autor;
DROP TABLE IF EXISTS livro CASCADE;
DROP TABLE IF EXISTS aluno CASCADE;
DROP TABLE IF EXISTS emprestimo;

CREATE TABLE autor (
    id SERIAL PRIMARY KEY,
    nome varchar,
    nacionalidade varchar
);

CREATE TABLE livro_autor (
    id_livro integer,
    id_autor integer
);

CREATE TABLE livro (
    id SERIAL PRIMARY KEY,
    titulo varchar,
    editora varchar,
    area varchar
);

CREATE TABLE emprestimo (
    id_leitor integer,
    id_livro integer,
    data_emprestimo timestamp,
    data_devolucao timestamp,
    retornou boolean
);

CREATE TABLE aluno (
    id SERIAL PRIMARY KEY,
    nome varchar,
    sobrenome varchar,
    endereco varchar,
    carreira varchar,
    idade integer
);

ALTER TABLE livro_autor ADD FOREIGN KEY("id_livro") REFERENCES livro ("id"); 
ALTER TABLE livro_autor ADD FOREIGN KEY("id_autor") REFERENCES autor ("id"); 
ALTER TABLE emprestimo ADD FOREIGN KEY("id_leitor") REFERENCES aluno ("id"); 
ALTER TABLE emprestimo ADD FOREIGN KEY("id_livro") REFERENCES livro ("id"); 

INSERT INTO autor (nome, nacionalidade) VALUES
    ('J.K. Rowling', 'britânica'),
    ('C.J. Date', 'americana'),
    ('John Viescas', 'americana'),
    ('Elena Ferrante', 'italiana'),
    ('Jorge Luis Borges', 'argentina'),
    ('Simone de Beauvoir', 'francesa');

INSERT INTO livro (titulo, editora, area) VALUES
    ('Harry Potter e a Pedra Filosofal', 'Rocco', 'Ficção'),
    ('Introdução a Sistemas de Bancos de Dados', 'Campus', 'Banco de Dados'),
    ('SQL Queries for Mere Mortals: A Hands-On Guide to Data Manipulation in SQL', 'Addison-Wesley Professional', 'Banco de Dados'),
    ('A Mulher Desiludida', 'Nova Fronteira', 'Ficção'),
    ('A amiga genial: Infância, adolescência', 'Biblioteca Azul', 'Ficção'),
    ('Ficções', 'Companhia das Letras', 'Ficção'),
    ('The Universe - A Travel Guide', 'Lonely Planet', 'Astronomy');

INSERT INTO livro_autor (id_autor, id_livro) VALUES
    ((SELECT id FROM autor WHERE nome = 'J.K. Rowling'), (SELECT id FROM livro WHERE titulo LIKE 'Harry%')),
    ((SELECT id FROM autor WHERE nome = 'C.J. Date'), (SELECT id FROM livro WHERE titulo LIKE 'Introdu%')),
    ((SELECT id FROM autor WHERE nome = 'John Viescas'), (SELECT id FROM livro WHERE titulo LIKE 'SQL Queries%')),
    ((SELECT id FROM autor WHERE nome = 'Elena Ferrante'), (SELECT id FROM livro WHERE titulo LIKE 'A amiga%')),
    ((SELECT id FROM autor WHERE nome = 'Jorge Luis Borges'), (SELECT id FROM livro WHERE titulo LIKE 'Ficções')),
    ((SELECT id FROM autor WHERE nome LIKE 'Simone%'), (SELECT id FROM livro WHERE titulo = 'A Mulher Desiludida')),
    ((null), (SELECT id FROM livro WHERE titulo LIKE 'The Universe%'));

INSERT INTO aluno (nome, sobrenome, endereco, carreira, idade) VALUES
    ('Emerson', 'Garotto', 'Rua Teodora, 23', 'artistica', 23),
    ('Luis', 'Fardinho', 'Rua Vinte Três, 12', 'jurídica', 33),
    ('Manuela', 'Parista', 'Rua Doze, 23', 'informática', 27),
    ('Flávia', 'Sardinha', 'Rua Treze, 13', 'informática', 33),
    ('Filippo', 'Galli', 'Rua Dezoito, 5', 'medicina', 45),
    ('Pedro', 'Pimenta', 'Rua Vinte Três, 12', 'informática', 41),
    ('Paula', 'Girotto', 'Rua Onze, s/n', 'matemárica', 23);

INSERT INTO emprestimo VALUES
    ((SELECT id FROM aluno WHERE sobrenome = 'Garotto'), (SELECT id FROM livro WHERE titulo LIKE 'Harry%'), '2021-01-09', '2021-02-09', true),
    ((SELECT id FROM aluno WHERE sobrenome = 'Galli'), (SELECT id FROM livro WHERE titulo LIKE 'A Mulher%'), '2021-03-23', '2021-04-23', true),
    ((SELECT id FROM aluno WHERE sobrenome = 'Sardinha'), (SELECT id FROM livro WHERE titulo LIKE 'SQL Queries%'), '2022-02-28', '2022-05-15', false);

