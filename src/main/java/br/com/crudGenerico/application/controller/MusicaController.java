package br.com.crudGenerico.application.controller;

import br.com.crudGenerico.domain.service.MusicaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@Controller
@RequestMapping("/musicas")
public class MusicaController {

    private final MusicaService musicaService;

    @GetMapping
    public ModelAndView getMusicas() {
        ModelAndView musicas = new ModelAndView("musicas");
        musicas.addObject("musicas", musicaService.findAll());
        return musicas;
    }

    @GetMapping("/{id}")
    public String getMusicasById(@PathVariable Long id) {
        return "musicas";
    }

}
