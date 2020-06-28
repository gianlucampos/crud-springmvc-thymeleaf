package br.com.crudGenerico.repository;

import br.com.crudGenerico.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Onde ficam as operações CRUD e consultas
 * @author gianlucampos
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
