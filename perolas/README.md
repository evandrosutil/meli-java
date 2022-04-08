# Jewelry

Insere uma jóia no banco

```bash
curl -X POST 'localhost:8080/joia/inserir' \
-H "Content-Type: application/json" \
-d '{
	"material": "niobio", 
	"weight": 0.34, 
	"carats": 8
}'
```

Lista todas as jóias do banco

```bash
curl -X GET 'localhost:8080/joias'
```

Deleta uma joia

```bash
curl -X DELETE 'localhost:8080/joia/excluir?numero_identificacao=9acb79e6-2025-4805-8bc6-1a23f6429f0a'
```

Atualiza uma joia

```bash
curl -X PUT 'localhost:8080/joia/atualizar?numero_identificacao=cf526c9e-c95c-4f05-bd0e-42cb0cffa2b6&material=titanium&weigth=0.55&carats=13'
```
