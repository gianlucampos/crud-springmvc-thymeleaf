package br.com.crudGenerico.application.dto;

import br.com.crudGenerico.common.utils.FormatterUtils;
import br.com.crudGenerico.domain.models.Produto;
import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProdutoDTO implements Serializable {

    private String id;
    private String nome;
    private String preco;

    public static Produto fromDTO(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setId(Long.valueOf(dto.getId()));
        produto.setNome(dto.getNome());
        produto.setPreco(FormatterUtils.parseCurrencyBRL(dto.getPreco()));
        return produto;
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + "]";
    }

}
