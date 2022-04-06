echo 'Listar os dados dos autores.\n'
psql biblioteca -c  "SELECT * FROM autor;"

echo 'Listar nome e idade dos alunos'
psql biblioteca -c "SELECT nome, idade FROM aluno;"

echo 'Quais alunos pertencem à carreira de informática?'
psql biblioteca -c "SELECT * FROM aluno WHERE carreira = 'informática';"

echo 'Quais autores são de nacionalidade francesa ou italiana?'
psql biblioteca -c "SELECT * FROM autor WHERE nacionalidade in ('francesa', 'italiana');"

echo 'Listar os dados dos alunos cuja idade é maior que a média.'
psql biblioteca -c "SELECT AVG(idade) idade_media FROM aluno;"
psql biblioteca -c "SELECT * FROM Aluno WHERE Idade > (SELECT AVG(Idade) idade_media FROM Aluno);"

echo 'Listar os nomes dos alunos cujo sobrenome começa com a letra G.'
psql biblioteca -c "SELECT nome FROM aluno WHERE sobrenome ~* '^G\w*';"

echo 'Que livros foram emprestados ao leitor “Filippo Galli”?'
psql biblioteca -c \
    "SELECT l.titulo
    FROM livro l
    LEFT JOIN emprestimo e ON l.id = e.id_livro
    LEFT JOIN aluno a ON e.id_leitor = a.id
    WHERE a.nome = 'Filippo' AND a.sobrenome = 'Galli';"

echo 'Listar os títulos dos livros que deveriam ser devolvidos até 16/07/2021.'
psql biblioteca -c \
    "SELECT titulo
    FROM Livro l
    LEFT JOIN emprestimo e ON l.id = e.id_livro
    WHERE data_devolucao <= '2021-07-16';"
