## Consultas SQL Avançadas - prática integradora 2

Para criar e popular o banco, executar:

`psql postgres -f funcionarios.sql`

1. Selecione o nome, cargo e localização dos departamentos onde os vendedores
trabalham.

```
SELECT 
    nome, 
    cargo, 
    localizacao
FROM funcionario 
LEFT JOIN departamento 
    ON funcionario.depto_nro = departamento.depto_nro
WHERE cargo = 'Vendedor';
```

2. Visualize departamentos com mais de cinco funcionários.
```
SELECT 
    nome_depto 
FROM (
    SELECT 
        departamento.nome_depto, 
        COUNT(funcionario.nome) as funcionarios
    FROM departamento
    LEFT JOIN funcionario 
        ON funcionario.depto_nro = departamento.depto_nro 
    GROUP BY departamento.nome_depto) sub_departamentos
WHERE funcionarios > 5;
```

3. Exiba o nome, salário e nome do departamento dos funcionários que têm o mesmo
cargo que 'Mito Barchuk'.

```
SELECT
    nome,
    salario
FROM funcionario
WHERE cargo = (
    SELECT cargo 
    FROM funcionario 
    WHERE nome|| ' ' ||sobrenome = 'Mito Barchuk');
```

4. Mostre os dados dos funcionários que trabalham no departamento de contabilidade,
ordenados por nome.

```
SELECT * 
FROM funcionario
LEFT JOIN departamento
    ON funcionario.depto_nro = departamento.depto_nro
WHERE departamento.nome_depto = 'Contabilidade'
ORDER BY funcionario.nome;
```

5. Mostre o nome do funcionário que tem o menor salário.

```
SELECT nome
FROM funcionario
WHERE salario = (
    SELECT MIN(salario)
    FROM funcionario);
```

6. Mostre os dados do funcionário que tem o maior salário no departamento 'Vendas'.
```
SELECT * 
FROM funcionario
WHERE salario = (
    SELECT MAX(salario)
    FROM funcionario
    LEFT JOIN departamento
        ON funcionario.depto_nro = departamento.depto_nro
    WHERE departamento.nome_depto = 'Vendas');
```
