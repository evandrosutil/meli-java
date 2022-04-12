# Tutoriais
Implementação de API REST para armazenamento e disponibilização de tutoriais.

* Criar um tutorial

```bash
curl -X POST 'localhost:8080/api/tutorials' \
-H 'Content-Type: application/json' \
-d '{
    "title": "Hibernate: nice, hum?",
    "description": "Persiste data in your application",
    "status": "review"
}'

curl -X POST 'localhost:8080/api/tutorials' \
-H 'Content-Type: application/json' \
-d '{
    "title": "Spring: building an API",
    "description": "Create your own API with Java and Spring"
    "status": "published"
}'

curl -X POST 'localhost:8080/api/tutorials' \
-H "Content-Type: application/json" \
-d '{
    "title": "Mastering Spring",
    "description": "Just creating a simple API is not enough.",
    "status": "tbp"
}'
```

* Listar todos os tutoriais criados
```bash
curl -X GET 'localhost:8080/api/tutorials'
```

* Buscar um tutorial pelo id
```bash
curl -X GET 'localhost:8080/api/tutorials/1'
```

* Atualizar um tutorial
```bash
curl -X PUT 'localhost:8080/api/tutorials/1' \
-H "Content-Type: application/json" \
-d '{
  "title": "Hibernate: nice, hum?",
    "description": "Persiste data in your application",
    "status": "tbp"
}'
```

* Excluir todos os tutoriais
```bash
curl -X DELETE 'localhost:8080/api/tutorials'
```

* Excluir um tutorial pelo id
```bash
curl -X DELETE 'localhost:8080/api/tutorials/1'
```

* Buscar todos os tutoriais publicados
```bash
curl -X GET 'localhost:8080/api/tutorials/published'
```

* Buscar todos os tutoriais que tenham uma determinada palavra no título
```bash
curl -X GET 'localhost:8080/api/tutorials?title=Spring'
```