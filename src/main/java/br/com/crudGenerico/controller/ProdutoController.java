package br.com.crudGenerico.controller;

import br.com.crudGenerico.models.Produto;
import br.com.crudGenerico.service.ProdutoService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author gianlucampos
 */
@Controller
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping("/")
    public ModelAndView searchProduto(Produto produto) {
        if (service.findAll().isEmpty()) {
            criaProdutos();
        }
        ModelAndView model = new ModelAndView("produtos-search");
        model.addObject("produto", produto);
        return model;
    }

    @GetMapping("/produtos")
    public ModelAndView findAll() {
        ModelAndView model = new ModelAndView("produtos-list");
        model.addObject("produtos", service.findAll());
        return model;
    }

    @GetMapping("/produtos/add")
    public ModelAndView addProduto(Produto produto) {
        ModelAndView model = new ModelAndView("produtos-add");
        model.addObject("produto", produto);
        return model;
    }

    @PostMapping("/produtos/save")
    public RedirectView saveProduto(Produto produto, RedirectAttributes redirectAttributes) {
        service.save(produto);
        redirectAttributes.addFlashAttribute("mensagem", "Cadastro feito com sucesso!");
        return new RedirectView("/produtos", true);
    }

    @PostMapping("/produtos/edit/{id}")
    public ModelAndView editProduto(@PathVariable("id") Long id) {
        Produto produto = (Produto) service.getOne(id);
        return addProduto(produto);
    }

    @DeleteMapping("/produtos/delete/{id}")
    public void deleteProduto(@PathVariable("id") Long id) {
        service.delete(id);
//        return findAll(service.findAll().get(0));
    }

    private void criaProdutos() {
        Produto produto = new Produto("Iphone 7", new BigDecimal(5000.00));
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
