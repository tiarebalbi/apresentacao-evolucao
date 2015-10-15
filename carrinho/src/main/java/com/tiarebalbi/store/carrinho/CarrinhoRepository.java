package com.tiarebalbi.store.carrinho;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * @author Tiarê Balbi Bonamini
 * @version 1.5.0
 */
@RepositoryRestResource(path = "carrinho", collectionResourceRel = "carrinho")
public interface CarrinhoRepository extends MongoRepository<Carrinho, String> {

    @Override
    @RestResource(exported = false)
    Carrinho save(Carrinho s);

    @RestResource(exported = false)
    Carrinho findByProdutoId(String produtoId);
}