package br.com.crudGenerico.application.configuration;

import br.com.crudGenerico.domain.models.Produto;
import br.com.crudGenerico.domain.service.ProdutoService;
import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    private final ProdutoService service;

    public ApplicationConfig(ProdutoService service) {
        this.service = service;
    }

    @PostConstruct
    private void criaProdutos() {
        Produto produto = new Produto("Iphone 7", new BigDecimal("5000.00"));
        service.save(produto);
        produto = new Produto("Android 10", new BigDecimal(2000.00));
        service.save(produto);
        produto = new Produto("SSD 480 gb", new BigDecimal(500.00));
        service.save(produto);
        produto = new Produto("Memória Ram 16gb", new BigDecimal(400.00));
        service.save(produto);
        produto = new Produto("Teclado RGB", new BigDecimal(200.00));
        service.save(produto);
    }

}
