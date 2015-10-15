# Apresentacao Evolucao

## Links

### Gateway
http://localhost:9023/

API: 
1. http://localhost:9023/api/catalogo/produtos 

2. http://localhost:9023/api/loja/carrinho

3. http://localhost:9023/api/loja/carrinho/adicionar


Eureka:
http://localhost:8761/

Example 
curl -H "Content-Type: application/json" -X POST -d '{"produto" : {"id":"561fd179a8265d64037eb8c8"}, "quantidade":3}' http://localhost:9023/api/loja/carrinho/adicionar
