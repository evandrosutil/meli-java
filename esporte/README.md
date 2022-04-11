

## Esportes

Adiciona um esporte
```bash
curl -X POST localhost:8080/addSport \
-H "Content-Type: application/json" \
-d '{"name": "volei", "level": "intermediário"}'
```

Lista os esportes
```bash
curl -X GET localhost:8080/findSports
```

Exibe o nível de um esporte caso ele tenha sido inserido
```bash
curl -X GET localhost:8080/findSport/{nome}
```

## Atleta

Adiciona um(a) atleta
```bash
curl -X POST localhost:8080/addPerson \
-H "Content-Type: application/json" \
-d '{
    "firstName": "Fernanda",
    "lastName": "Garay",
    "age": 35,
    "sport": "volei"
}'  
```

Lista os/as atletas
```bash
curl -X GET localhost:8080/athletes
```