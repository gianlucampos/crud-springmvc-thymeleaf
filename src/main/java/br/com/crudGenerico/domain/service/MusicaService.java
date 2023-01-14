package br.com.crudGenerico.domain.service;

import br.com.crudGenerico.domain.models.Musica;
import br.com.crudGenerico.domain.repository.MusicaRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MusicaService {

    private final MusicaRepository repository;

    public List<Musica> findAll() {
        return repository.findAll();
    }

    public Optional<Musica> findById(Long id) {
        return repository.findById(id);
    }

    public List<Musica> findByNome(String nome) {
        return repository.findByNome(nome);
    }

    public Musica save(Musica musica) {
        return repository.save(musica);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
