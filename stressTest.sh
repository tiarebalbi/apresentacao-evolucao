#!/bin/bash

for i in {1..100}
do
   echo "Cadastrando Produto $i"
   curl -H "Content-Type: application/json" -X POST -d '{"produto" : {"id":"561c49e4a8263f2d7630d06e"}, "quantidade": "1"}' http://localhost:9023/api/loja/carrinho/adicionar
done