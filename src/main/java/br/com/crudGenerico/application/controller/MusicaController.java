package br.com.crudGenerico.application.controller;

import br.com.crudGenerico.domain.models.Musica;
import br.com.crudGenerico.domain.service.MusicaService;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@AllArgsConstructor
@Controller
public class MusicaController {

    private final MusicaService musicaService;

    @GetMapping("/musicas")
    public ModelAndView getMusicas() {
        ModelAndView musicas = new ModelAndView("musicas");
        musicas.addObject("musicas", musicaService.findAll());
        return musicas;
    }

    @PostMapping("**/filterMusica")
    public ModelAndView getMusicasByFilter(@RequestParam("idMusica") Long idMusica, @RequestParam("nomeMusica") String nomeMusica) {
        if (idMusica == null && nomeMusica.isEmpty()) {
            return getMusicas();
        }
        List<Musica> musicas = new ArrayList<>();
        if (nomeMusica.isEmpty()) {
            musicaService.findById(idMusica).ifPresent(musicas::add);
        } else {
            musicas = musicaService.findByNome(nomeMusica);
        }
        ModelAndView mv = new ModelAndView("musicas");
        mv.addObject("musicas", musicas);
        return mv;
    }

    @PostMapping("musicas/delete/{id}")
    public RedirectView deleteMusica(@PathVariable("id") Long id) {
        musicaService.delete(id);
        return new RedirectView("/musicas", true);
    }

}
