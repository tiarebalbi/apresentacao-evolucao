package com.tiarebalbi.store.carrinho;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * @author Tiarê Balbi Bonamini
 * @version 1.5.0
 */
public class Produto {

    @JsonProperty("id")
    private String ref;

    private String nome;

    private BigDecimal valor;

    public String getRef() {
        return ref;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
