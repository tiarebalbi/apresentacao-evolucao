package com.tiarebalbi.store;

import com.tiarebalbi.store.carrinho.CarrinhoRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication
public class CarrinhoDaLojaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarrinhoDaLojaApplication.class, args);
    }

    @Bean
    public InitializingBean reset(CarrinhoRepository repository) {
        return repository::deleteAll;
    }
}