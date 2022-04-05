# Consultas SQL Avançadas

Prática Integradora 3.


## Exercício 1

1. Listar os dados dos autores.
```
SELECT Nome, Nacionalidade
FROM Autor
```

2. Listar nome e idade dos alunos.

```
SELECT nome, idade
FROM Aluno
```

3. Quais alunos pertencem à carreira de informática?

```
SELECT nome|| ' ' ||sobrenome
FROM Aluno
WHERE carreira = 'informática'
```

4. Quais autores são de nacionalidade francesa ou italiana.

```
SELECT Nome
FROM Autor
WHERE Nacionalidade in ('francesa', 'italiana')
```

5. Que livros não são da área da internet?

```
SELECT Título
FROM Livro
WHERE Area <> 'internet'
```

6. Listar os livros da editora Salamandra.

```
SELECT *
FROM Livro
WHERE Editora = 'Salamandra'
```

7. Listar os dados dos alunos cuja idade é maior que a média.

```
SELECT *
FROM Aluno
WHERE Idade > (SELECT AVG(Idade) idade_media FROM Aluno)
```

8. Listar os nomes dos alunos cujo sobrenome começa com a letra G.

```
SELECT nome
FROM Aluno
WHERE sobrenome LIKE 'G%'
```

9. Listar os autores do livro "O Universo: Guia de Viagem". (Apenas nomes devem ser listados.)

```
SELECT a.Nome
FROM Autor a
LEFT JOIN LivroAutor la ON la.idAutor = a.idAutor
LEFT JOIN Livro l ON la.idLivro = l.idLivro
WHERE l.Titulo = 'O Universo: Guia de Viagem'
```

10. Listar autores  que tenham nacionalidade italiana ou argentina.

```
SELECT *
FROM Autor
WHERE Nacionalidade IN ('italiana', 'argentina')
```

11. Que livros froam emprestados ao leitor 'Filippo Galli'? 

```
SELECT l.Titulo
FROM Livro l
LEFT JOIN Emprestimo e ON l.idLivro = e.idLivro
LEFT JOIN Aluno a ON e.idLeitor = a.idAluno
WHERE a.nome = 'Filippo' AND a.sobrenome = 'Galli'
```

12. Listar o nome do aluno mais novo.

```
SELECT nome
FROM Aluno
WHERE idade = (SELECT MIN(idade) FROM aluno)
```

13. Listar os nomes dos alunos a quem os livros de Banco de Dados from emprestados.

```
SELECT nome
FROM Aluno a
LEFT JOIN Emprestimo e ON a.idAluno = e.idLeitor
LEFT JOIN Livro l ON e.idLivro = l.idLivro
WHERE l.Area = 'Banco de Dados'
```

14. Listar os livros que pertencem à autora J.K. Rowling.

```
SELECT *
FROM Livro l
LEFT JOIN LivroAutor la ON la.idLivro = la.idLivro
LEFT JOIN Autor a ON la.idAutor = a.idAutor
WHERE a.Nome = 'J.K. Rowling'
```

15. Listar os títulos dos livros que deveriam ser devolvidos até 16/07/2021.

```
SELECT Titulo
FROM Livro l
LEFT JOIN Emprestimo e ON l.idLivro = e.idLivro
WHERE data_devolucao <= '2021-07-16'
```
