package br.com.crudGenerico.controller;

import br.com.crudGenerico.models.Produto;
import br.com.crudGenerico.service.ProdutoService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView index() {
        if (service.findAll().isEmpty()) {
            criaProdutos();
        }
        ModelAndView model = new ModelAndView("produtos-search");
        return model;
    }

    @PostMapping("/find/{id}/{nome}")
    public ModelAndView findProduto(@RequestParam("id") Long id, @RequestParam("nome") String nome) {
        ModelAndView model = new ModelAndView("produtos-list");
        List<Produto> produtos = service.findAll();
        if (id != null) {
            if (service.findById(id).isPresent()) {
                produtos = Arrays.asList(service.findById(id).get());
            } else {
                produtos = new ArrayList<>();
            }
        }
        if (!"".equals(nome.trim())) {
            nome = nome.trim().toLowerCase();
            produtos = service.findByNome("%" + nome + "%%");
        }
        model.addObject("produtos", produtos);
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
        redirectAttributes.addFlashAttribute("mensagem", "Operação realizada com sucesso!");
        return new RedirectView("/produtos", true);
    }

    @PostMapping("/produtos/edit/{id}")
    public ModelAndView editProduto(@PathVariable("id") Long id) {
        Produto produto = (Produto) service.findById(id).get();
        return addProduto(produto);
    }

    @PostMapping("/produtos/delete/{id}")
    public RedirectView deleteProduto(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        service.delete(id);
        redirectAttributes.addFlashAttribute("mensagem", "Removido com sucesso!");
        return new RedirectView("/produtos", true);
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
