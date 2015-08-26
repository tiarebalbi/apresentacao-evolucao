package com.tiarebalbi.store.carrinho;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * @author Tiarê Balbi Bonamini
 * @version 1.5.0
 */
public class Produto {

    private String ref;

    private String nome;

    private BigDecimal valor;

    public Produto(@JsonProperty String ref, @JsonProperty String nome, @JsonProperty BigDecimal valor) {
        this.ref = ref;
        this.nome = nome;
        this.valor = valor;
    }

    public String getRef() {
        return ref;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
