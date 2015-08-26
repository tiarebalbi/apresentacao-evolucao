package com.tiarebalbi.store.carrinho;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tiarebalbi.store.produto.ProdutoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

/**
 * @author Tiarê Balbi Bonamini
 * @version 1.5.0
 */
@BasePathAwareController
@RequestMapping("/carrinho")
public class CarrinhoRestController implements ResourceProcessor<RepositoryLinksResource>, ResourceAssembler<Carrinho, Resource<Carrinho>> {

    private final Logger LOGGER = Logger.getLogger("c.t.s.c.CarrinhoRestController");

    private final ProdutoClient produtoClient;

    private final CarrinhoRepository carrinhoRepository;

    @Autowired
    private RepositoryEntityLinks entityLinks;

    @Autowired
    public CarrinhoRestController(ProdutoClient produtoClient, CarrinhoRepository carrinhoRepository) {
        this.produtoClient = produtoClient;
        this.carrinhoRepository = carrinhoRepository;
    }

    @HystrixCommand(fallbackMethod = "registrarFalha")
    @RequestMapping(method = RequestMethod.POST, value = "/adicionar")
    public ResponseEntity<Resource<Carrinho>> salvar(@RequestBody Carrinho carrinho) {

        Produto produto = this.produtoClient.consultarProduto(carrinho.getProduto().getRef());
        carrinho.setProduto(produto);

        return new ResponseEntity<>(toResource(this.carrinhoRepository.save(carrinho)), HttpStatus.OK);
    }

    /**
     * Método de fallback com sua lógica
     *
     * @param carrinho
     * @return Carrinho
     */
    public ResponseEntity<Resource<Carrinho>> registrarFalha(Carrinho carrinho) {
        LOGGER.finest("Ocorreu um problema ao registrar o carrinho: " + carrinho);

        // Exemplo: Mesmo ele não conseguindo consultar os dados do produto eu quero guardar os dados da requisição
        return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
    }

    @Override
    public Resource<Carrinho> toResource(Carrinho entity) {
        LinkBuilder lb = entityLinks.linkFor(Carrinho.class, "carrinho");
        Resource<Carrinho> resource = new Resource<>(entity);
        resource.add(new Link(lb.toString() + "/adicionar"));
        return resource;
    }

    @Override
    public RepositoryLinksResource process(RepositoryLinksResource resource) {
        LinkBuilder lb = entityLinks.linkFor(Carrinho.class, "carrinho");
        resource.add(new Link(lb.toString() + "/adicionar"));
        return resource;
    }
}
