#QA Bugs
Objetivo da prática é implementar uma API Rest que permita a um testador acompanhar os processos que está
realizando em um banco de dados.

Para adicionar um caso de teste
```bash
curl -X POST localhost:8080/api/testcases/new -H "Content-Type: application/json" -d '{"description": "random first test", "tested": true, "passed": false, "number_of_tries": 13, "date": "2022-01-23"}'

curl -X POST localhost:8080/api/testcases/new -H "Content-Type: application/json" -d '{"description": "random second test", "tested": true, "passed": true, "number_of_tries": 23, "date": "2022-01-24"}'
```

Listar os casos de teste inseridos no banco
```bash
curl -X GET localhost:8080/api/testcases
```

Listar um caso de teste pelo id
```bash
curl -X GET localhost:8080/api/testcases/1
```

Atualizar um caso de teste
```bash
curl -X PUT localhost:8080/api/testcases/2 -H "Content-Type: application/json" -d '{"description": "new one", "tested": true, "passed": true, "number_of_tries": 23}'
```

Deletar um caso de teste pelo id
```bash
curl -X DELETE localhost:8080/api/testcases/2
```

Buscar um caso de teste pela data de atualização
```bash
curl -X GET localhost:8080/api/testcases?last_update='12-04-2022'
```