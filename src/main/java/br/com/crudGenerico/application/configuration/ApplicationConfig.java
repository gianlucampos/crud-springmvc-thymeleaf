package br.com.crudGenerico.application.configuration;

import br.com.crudGenerico.domain.models.Musica;
import br.com.crudGenerico.domain.models.Produto;
import br.com.crudGenerico.domain.service.MusicaService;
import br.com.crudGenerico.domain.service.ProdutoService;
import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class ApplicationConfig {

    private final ProdutoService produtoService;
    private final MusicaService musicaService;

    @PostConstruct
    private void criaProdutos() {
        Produto produto = new Produto("Iphone 7", new BigDecimal("5000.00"));
        produtoService.save(produto);
        produto = new Produto("Android 10", new BigDecimal("2000.00"));
        produtoService.save(produto);
        produto = new Produto("SSD 480 gb", new BigDecimal("500.00"));
        produtoService.save(produto);
        produto = new Produto("Memória Ram 16gb", new BigDecimal("400.00"));
        produtoService.save(produto);
        produto = new Produto("Teclado RGB", new BigDecimal("200.00"));
        produtoService.save(produto);
    }

    @PostConstruct
    private void criaMusicas() {
        Musica musica = Musica.builder()
            .nome("Under The Bridge")
            .artista("Red Hot Chili Peppers")
            .album("Blood Sugar Sex Magik")
            .ano(1991)
            .build();
        musicaService.save(musica);
        musica = Musica.builder()
            .nome("Scar Tissue")
            .artista("Red Hot Chili Peppers")
            .album("Californication")
            .ano(1999)
            .build();
        musicaService.save(musica);
        musica = Musica.builder()
            .nome("Dani California")
            .artista("Red Hot Chili Peppers")
            .album("Stadium Arcadium")
            .ano(2006)
            .build();
        musicaService.save(musica);
    }

}
