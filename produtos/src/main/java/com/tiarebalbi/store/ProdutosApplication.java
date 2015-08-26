package com.tiarebalbi.store;

import com.tiarebalbi.store.produtos.Produto;
import com.tiarebalbi.store.produtos.ProdutoRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.logging.Logger;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class ProdutosApplication {

    private final Logger LOGGER = Logger.getLogger("c.t.s.ProdutosApplication");

    public static void main(String[] args) {
        SpringApplication.run(ProdutosApplication.class, args);
    }

    @Bean
    public InitializingBean initProdutos(ProdutoRepository produtoRepository) {
        return () -> {

            LOGGER.info("Inicializando os produtos da loja....");

            // Resetando os produtos já cadastrados.
            produtoRepository.deleteAll();

            // Registro de produtos
            produtoRepository.save(new Produto("Produto 1", "Descrição 1", new BigDecimal(1)));
            produtoRepository.save(new Produto("Produto 2", "Descrição 2", new BigDecimal(2)));
            produtoRepository.save(new Produto("Produto 3", "Descrição 3", new BigDecimal(3)));
            produtoRepository.save(new Produto("Produto 4", "Descrição 4", new BigDecimal(4)));

        };
    }


}
