package br.com.crudGenerico.controller;

import br.com.crudGenerico.models.Produto;
import br.com.crudGenerico.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author gianlucampos
 */
@Controller
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping("/")
    public ModelAndView listaProdutos(Produto produto) {
        ModelAndView model = new ModelAndView("/produtos-search");
        model.addObject("produtos", service.findAll());
        return model;
    }

    @GetMapping("/produtos")
    public ModelAndView findAll(Produto produto) {
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
    public ModelAndView saveProduto(Produto produto) {
        service.save(produto);
        return findAll(produto);
    }

    @GetMapping("/produtos/edit/{id}")
    public ModelAndView editProduto(@PathVariable("id") Long id) {
        Produto produto = (Produto) service.getOne(id);
        return addProduto(produto);
    }

    @GetMapping("/produtos/delete/{id}")
    public ModelAndView deleteProduto(@PathVariable("id") Long id) {
        service.delete(id);
        return findAll(null);
    }
}
