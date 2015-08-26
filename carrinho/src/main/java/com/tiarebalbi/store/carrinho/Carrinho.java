package com.tiarebalbi.store.carrinho;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Tiarê Balbi Bonamini
 * @version 1.5.0
 */
@Document
public class Carrinho {

    @Id
    private String id;

    // Deveria ter aqui uma referencia de quem adicionou,
    // mas não vou estar entrando neste ponto pois  o objetivo é apenas demonstrar a integração

    private int quantidade;

    private Produto produto;

    @PersistenceConstructor
    public Carrinho(@JsonProperty @Value("#root.quantidade == 0 ? 1 :") int quantidade, @JsonProperty Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Carrinho{");
        sb.append("id='").append(id).append('\'');
        sb.append(", quantidade=").append(quantidade);
        sb.append(", produto=").append(produto);
        sb.append('}');
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
