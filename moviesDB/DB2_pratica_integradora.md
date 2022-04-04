## Parte 1

1. Como é chamado um JOIN em um banco de dados e para que é usado?
A cláusula JOIN é usada para combinar duas ou mais tabelas com base na relação existente entre elas.

2. Explique os tipos de JOIN.
INNER JOIN: faz a união quando os valores são iguais em ambas as tabelas.
LEFT & RIGHT JOINs: retorna todos os valores da tabela esquerda ou direita e os registros correspondentes na outra tabela.
FULL ou OUTER JOIN: retorna todos os valores quando há um match na tabela da direita ou da esquerda. 

3. Para que serve o GROUP BY?
O Group By serve para agrupar resultados por determinadas colunas, geralmente mostrando resultado de alguma função agregadora, como MAX, MIN, etc.

4. Para que serve o HAVING?
O Having funciona de forma semelhante ao WHERE, mas é usado para filtrar os resultados agrupados.

5. Escreva uma consulta genérica para cada um dos seguintes diagramas:

```
SELECT * FROM costumer INNER JOIN order ON order.customer_id = customer.id

SELECT * FROM transactions LEFT JOIN customer ON transaction.customer_id = customer.id
```

## Parte 2
Consultas ao movies_db

1. Mostrar o título e o nome do gênero de todas as séries.
`SELECT title, genres.name FROM movies LEFT JOIN genres ON genres.id = movies.genre_id`

2. Mostrar o título dos episódios, o nome e sobrenome dos atores que trabalham em
cada um deles.
```
SELECT
    episodes.title,
    actors.first_name,
    actors.last_name
FROM
    episodes
LEFT JOIN 
    actor_episode 
    ON actor_episode.episode_id = episodes.id
LEFT JOIN 
    actors
    ON actors.id = actor_episode.actor_id;
```

3. Mostrar o título de todas as séries e o número total de temporadas que cada uma
delas possui.

```
SELECT 
    series.title,
    count(episodes.title) as episodios
FROM
    seasons 
LEFT JOIN series 
    ON series.id = seasons.serie_id 
LEFT JOIN episodes 
    ON episodes.season_id =  seasons.id 
GROUP BY series.title;
```

4. Mostrar o nome de todos os gêneros e o número total de filmes de cada um, desde
que seja maior ou igual a 3.

```
SELECT 
    genres.name,
    count(movies.title) as 
FROM genres 
LEFT JOIN movies 
    ON genres.id = movies.genre_id
GROUP BY genres.name
HAVING count(movies.title) >= 3;
```

5. Mostrar apenas o nome e sobrenome dos atores que atuam em todos os filmes de
Star Wars e que estes não se repitam.

```
WITH sub_sw_movie AS (
	SELECT
		actor_id,
		count(movie_id)
	FROM actor_movie 
	WHERE movie_id IN (
		SELECT distinct id 
		FROM movies 
		WHERE title ~* 'Guerra nas Estrela')
	GROUP BY actor_id 
	HAVING count(movie_id) = (SELECT count(*) FROM movies WHERE title ~* 'Guerra nas Estrela'))

SELECT
	first_name,
	last_name
FROM actors
INNER JOIN sub_sw_movie sm ON sm.actor_id = actors.id;	
```
