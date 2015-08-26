package com.tiarebalbi.store.produtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * @author Tiarê Balbi Bonamini
 * @version 1.5.0
 */
@Document
public class Produto {


    @Id
    private String id;

    @Version
    private Integer version;

    private String nome;

    private String descricao;

    private BigDecimal valor;

    @PersistenceConstructor
    public Produto(@JsonProperty String nome, @JsonProperty String descricao, @JsonProperty BigDecimal valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
