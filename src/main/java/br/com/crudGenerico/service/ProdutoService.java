package br.com.crudGenerico.service;

import br.com.crudGenerico.models.Produto;
import br.com.crudGenerico.repository.ProdutoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe destinada a receber regras de negócio a respeito do Produto
 *
 * @author gianlucampos
 */
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

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
