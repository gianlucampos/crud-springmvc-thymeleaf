package br.com.crudGenerico.domain.models;

import br.com.crudGenerico.application.dto.ProdutoDTO;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Produto implements Serializable {

    @Id
    @SequenceGenerator(name = "seqproduto", sequenceName = "seqproduto", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqproduto")
    private Long id;
    @Column
    private String nome;
    @Column
    private BigDecimal preco;

    public Produto() {
    }

    public Produto(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Produto(ProdutoDTO produto) {
        this.id = !"".equals(produto.getId()) ? Long.parseLong(produto.getId()) : null;
        this.nome = produto.getNome();
        this.preco = new BigDecimal(produto.getPreco().replace(".", "").replace(",", "."));
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + "]";
    }

}
