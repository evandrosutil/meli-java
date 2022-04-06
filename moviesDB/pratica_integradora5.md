1. Adicione um filme à tabela de filmes.
```
INSERT INTO movies (id, title, rating, awards, release_date, length, genre_id) VALUES (22, 'Na Natureza Selvagem', 8.1, 0, '2008-03-04', 148, 3)
```

2. Adicione um gênero à tabela de gêneros.
```
INSERT INTO genres (id, created_at, name, ranking, active) VALUES (13, '2022-05-06', 'Historico', 13, 1);
```

3. Associe o filme do ponto 1. com o gênero criado no ponto 2.
```
UPDATE movies SET genre_id = 13 WHERE title = 'Na Natureza Selvagem';
```

4. Modifique a tabela de atores para que pelo menos um ator tenha o filme adicionado
no ponto 1 como favorito.
```
UPDATE actors SET favorite_movie_id = 22 WHERE id = 29;
```

5. Crie uma tabela temporária da tabela filmes.
`CREATE TEMPORARY TABLE tmp_movies AS SELECT * FROM movies;`

6. Elimine dessa tabela temporária todos os filmes que ganharam menos de 5 prêmios.
`DELETE FROM tmp_movies WHERE awards < 5;`

7. Obtenha a lista de todos os gêneros que possuem pelo menos um filme.
`select name,count(movies.title) from genres left join movies on movies.genre_id = genres.id group by genres.name having count(movies.title) > 0;`

8. Obtenha a lista de atores cujo filme favorito ganhou mais de 3 prêmios.
`SELECT actors.first_name|| ' ' ||actors.last_name as nome, count(movies.title) FROM actors LEFT JOIN movies ON movies.id = actors.favorite_movie_id GROUP BY nome HAVING count(movies.title) > 3;`

9. Crie um índice no nome na tabela de filmes.
`CREATE INDEX movies_title ON movies (title);`

10. Verifique se o índice foi criado corretamente.
```
SELECT
    indexname,
    indexdef
FROM
    pg_indexes
WHERE
    tablename = 'movies';
```

11. No banco de dados movies, haveria uma melhoria notável na criação de índices?
Analise e justifique a resposta.
A criação de novos índices melhoraria bastante a consulta no banco de dados movies. Até o exercício anterior, apenas as chaves primárias era tidas como tal. A criação de índice no nome do filme, por exemplo, evitaria uma varredura completa e permitiria o acesso mais direto aos dados. A melhora seria mais notável a medida que o banco crescesse.


12. Em que outra tabela você criaria um índice e por quê? Justifique a resposta.
Na tabela atores, nas colunas nome e sobrenome. A busca por alguém dessa tabela provavelmente seria feita pelo nome/sobrenome e a criação de índices nesses campos traria ganhos no tempo de resposta pelos motivos já mencionados na resposta anterior.
