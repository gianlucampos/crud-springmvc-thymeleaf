package br.com.crudGenerico.domain.repository;

import br.com.crudGenerico.domain.models.Musica;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {

    @Query("SELECT m FROM Musica m WHERE lower(m.nome) like %:nome%")
    List<Musica> findByNome(@Param("nome") String nome);
}
