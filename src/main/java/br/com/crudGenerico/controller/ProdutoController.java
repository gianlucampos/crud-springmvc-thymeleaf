package br.com.crudGenerico.controller;

import br.com.crudGenerico.models.Produto;
import br.com.crudGenerico.service.ProdutoService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

/**
 *
 * @author gianlucampos
 */
@Controller
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping("/")
    public ModelAndView listaProdutos() {
        ModelAndView model = new ModelAndView("/produtos-list");
        model.addObject("produtos", service.findAll());
        return model;
    }

    @GetMapping("/produtos")
    public ModelAndView findAll(Produto produto) {
        System.out.println(produto);
        ModelAndView model = new ModelAndView("produtos-search");
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

}
