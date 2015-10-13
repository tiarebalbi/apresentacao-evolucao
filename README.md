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
curl -H "Content-Type: application/json" -X POST -d '{"produto" : {"id":"561c49e4a8263f2d7630d06e"}, "quantidade":3}' http://localhost:9023/api/loja/carrinho/adicionar
