package br.com.crudGenerico.application.dto;

import br.com.crudGenerico.domain.models.Produto;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ProdutoDTO implements Serializable {

    private String id;
    private String nome;
    private String preco;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Produto produto) {
        if (produto != null) {
            this.id = produto.getId().toString();
            this.nome = produto.getNome();
            DecimalFormat df = new DecimalFormat("#,##0.00", DecimalFormatSymbols.getInstance(Locale.forLanguageTag("pt-BR")));
            this.preco = df.format(produto.getPreco());
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + "]";
    }

}
