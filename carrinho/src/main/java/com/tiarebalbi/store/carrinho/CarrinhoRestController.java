package com.tiarebalbi.store.carrinho;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tiarebalbi.store.produto.ProdutoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

/**
 * @author Tiarê Balbi Bonamini
 * @version 1.5.0
 */
@RepositoryRestController
@RequestMapping("/carrinho")
public class CarrinhoRestController {

    private final Logger LOGGER = Logger.getLogger("c.t.s.c.CarrinhoRestController");

    private final ProdutoClient produtoClient;

    private final CarrinhoRepository carrinhoRepository;

    @Autowired
    public CarrinhoRestController(ProdutoClient produtoClient, CarrinhoRepository carrinhoRepository) {
        this.produtoClient = produtoClient;
        this.carrinhoRepository = carrinhoRepository;
    }

    @HystrixCommand(fallbackMethod = "registrarFalha")
    @RequestMapping(method = RequestMethod.POST, value = "/adicionar")
    public
    @ResponseBody
    ResponseEntity<Carrinho> salvar(@RequestBody Carrinho carrinho) {

        Produto produto = this.produtoClient.consultarProduto(carrinho.getProduto().getId());
        carrinho.setProduto(produto);

        carrinho.calcularTotal();

        return new ResponseEntity<>(this.carrinhoRepository.save(carrinho), HttpStatus.OK);
    }

    /**
     * Método de fallback com sua lógica
     *
     * @param carrinho
     * @return Carrinho
     */
    public
    @ResponseBody
    ResponseEntity<Carrinho> registrarFalha(Carrinho carrinho) {
        LOGGER.finest("Ocorreu um problema ao registrar o carrinho: " + carrinho);

        // Exemplo: Mesmo ele não conseguindo consultar os dados do produto eu quero guardar os dados da requisição
        return new ResponseEntity<>(carrinho, HttpStatus.SERVICE_UNAVAILABLE);
    }

}
