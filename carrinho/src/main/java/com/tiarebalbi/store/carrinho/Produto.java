package com.tiarebalbi.store.carrinho;

import java.math.BigDecimal;

/**
 * @author Tiarê Balbi Bonamini
 * @version 1.5.0
 */
public class Produto {

    private String id;

    private String nome;

    private BigDecimal valor;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Produto{");
        sb.append("id='").append(id).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", valor=").append(valor);
        sb.append('}');
        return sb.toString();
    }
}
