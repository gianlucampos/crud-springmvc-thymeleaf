package br.com.crudGenerico.domain.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Musica {

    @Id
    @SequenceGenerator(name = "seq_musica", sequenceName = "seq_produto", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_produto")
    private Long id;
    private String nome;
    private String artista;
    private String album;
    private Integer ano;


}
