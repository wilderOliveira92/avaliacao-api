# Getting Started

# Avaliacao

## Instalação do projeto

Abrir terminal na pasta raiz do projeto
Realizar o build para criar o .jar com o comando: 

```
mvn clean package
```

Criar imagem docker com o .jar do projeto:

```
docker build -t avaliacao-api .
```

Executar imagem docker criada anteriormente:
```
docker run -p 8080:8080 avaliacao-api
```


## Documentação Swagger

Após o projeto executado
Documentação disponível em:
```
http://localhost:8080/swagger-ui/index.html
```
