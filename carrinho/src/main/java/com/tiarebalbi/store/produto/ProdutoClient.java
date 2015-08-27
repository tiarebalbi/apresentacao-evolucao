package com.tiarebalbi.store.produto;

import com.tiarebalbi.store.carrinho.Produto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Tiarê Balbi Bonamini
 * @version 1.5.0
 */
@FeignClient("produtos-service")
public interface ProdutoClient {

    @RequestMapping(method = RequestMethod.GET, value = "/produtos/{idProduto}")
    Produto consultarProduto(@PathVariable("idProduto") String idProduto);
}
