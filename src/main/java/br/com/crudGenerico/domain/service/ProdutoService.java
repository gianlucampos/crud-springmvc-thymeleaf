package br.com.crudGenerico.domain.service;

import br.com.crudGenerico.domain.models.Produto;
import br.com.crudGenerico.domain.repository.ProdutoRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Classe destinada a receber regras de negócio a respeito do Produto
 *
 * @author gianlucampos
 */
@AllArgsConstructor
@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Optional<Produto> findById(Long id) {
        return repository.findById(id);
    }

    public Produto save(Produto produto) {
        return repository.save(produto);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
    
    public List<Produto> findByNome(String nome){
        return repository.findByNome(nome);
    }

}
