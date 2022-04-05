CREATE DATABASE empresa;

-- connect to the created database
\c empresa;

CREATE TABLE funcionario (
    cod_fuc varchar PRIMARY KEY,
    nome varchar,
    sobrenome varchar,
    cargo varchar,
    data_alta timestamp,
    salario decimal,
    comissao decimal,
    depto_nro varchar
);

CREATE TABLE departamento (
    depto_nro varchar PRIMARY KEY,
    nome_depto varchar,
    localizacao varchar
);

INSERT INTO funcionario VALUES
    ('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
    ('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
    ('E-0003', 'Mariela', 'Barrios', 'Diretor', '2014-06-05', 185000, 0, 'D-000-3'),
    ('E-0004', 'Jonathan', 'Aguillera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
    ('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
    ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
    ('E-0007', 'Emilio', 'Galarza', 'Desenvolvedor', '2014-08-02', 60000, 0, 'D-000-1');

INSERT INTO departamento VALUES
    ('D-000-1', 'Software', 'Los Tigres'),
    ('D-000-2', 'Sistemas', 'Guadalupe'),
    ('D-000-3', 'Contabilidade', 'La Roca'),
    ('D-000-4', 'Vendas', 'Plata');
