package br.com.crudGenerico.application.controller;

import br.com.crudGenerico.application.dto.ProdutoDTO;
import br.com.crudGenerico.domain.models.Produto;
import br.com.crudGenerico.domain.service.ProdutoService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@AllArgsConstructor
@Controller
public class ProdutoController {

    private final ProdutoService service;

    @GetMapping("/filterProdutos")
    public ModelAndView findProduto(@RequestParam("id") Long id, @RequestParam("nome") String nome) {
        ModelAndView model = new ModelAndView("produtos-list");
        List<Produto> produtos = service.findAll();
        if (id != null) {
            if (service.findById(id).isPresent()) {
                produtos = Collections.singletonList(service.findById(id).get());
            } else {
                produtos = new ArrayList<>();
            }
        }
        if (!"".equals(nome.trim())) {
            nome = nome.trim().toLowerCase();
            produtos = service.findByNome("%" + nome + "%%");
        }
        model.addObject("produtos", produtos);
        model.addObject("mensagem", null);
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
    public RedirectView saveProduto(ProdutoDTO produto, RedirectAttributes redirectAttributes) {
        Produto produtoSaved = service.save(ProdutoDTO.fromDTO(produto));
        redirectAttributes.addAttribute("produto", produtoSaved);
        redirectAttributes.addFlashAttribute("mensagem", "Operação realizada com sucesso!");
        return new RedirectView("/produtos", true);
    }

    @PostMapping("/produtos/edit/{id}")
    public ModelAndView editProduto(@PathVariable("id") Long id) {
        Produto produto = service.findById(id).orElse(new Produto());
        return addProduto(produto);
    }

    @PostMapping("/produtos/delete/{id}")
    public RedirectView deleteProduto(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        service.delete(id);
        redirectAttributes.addFlashAttribute("mensagem", "Removido com sucesso!");
        return new RedirectView("/produtos", true);
    }

}
