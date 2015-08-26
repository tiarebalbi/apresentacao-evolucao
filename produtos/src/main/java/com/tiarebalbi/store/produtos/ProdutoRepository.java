package com.tiarebalbi.store.produtos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Tiarê Balbi Bonamini
 * @version 1.5.0
 */
@RepositoryRestResource(collectionResourceRel = "produtos", path = "produtos")
public interface ProdutoRepository extends MongoRepository<Produto, String> {
}