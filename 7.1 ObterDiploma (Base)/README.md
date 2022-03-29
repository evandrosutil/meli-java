# Rodando o projeto

## Instale as dependências do Maven
`mvn install`

## Faça o build do projeto
`mvn package`

## Rode o projeto localmente

`java -jar ./target/obterdiploma-0.0.1-SNAPSHOT.jar`

## Faça uma chamada

Com todos os campos válidos.

```BASH
curl -X POST http://localhost:8080/analyzeScores -H "Content-Type: application/json" -d \
'{
    "studentName": "Juan",
    "subjects": [
        {
            "name": "Matemática",
            "score": 10
        },
        {
            "name": "Física",
            "score": 10
        },
        {
            "name": "Química",
            "score": 6
        }
    ]
}'
```


Com valores inválidos para alguns campos:

```BASH
curl -X POST http://localhost:8080/analyzeScores -H "Content-Type: application/json" -d \
'{
    "studentName": "juan",
    "subjects": [
        {
            "name": "matemática",
            "score": 11
        },
        {
            "name": "física",
            "score": -2
        },
        {
            "name": "Química",
            "score": 6
        }
    ]
}'
```
