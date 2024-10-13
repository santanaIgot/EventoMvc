package br.com.cp.fiap.EventosMvc.controller;

import br.com.cp.fiap.EventosMvc.model.Evento;

import br.com.cp.fiap.EventosMvc.repository.EventoRepository;
import br.com.cp.fiap.EventosMvc.service.EventoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private EventoService eventoService;

    @GetMapping("/cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("evento", new Evento());
        return "evento/cadastrar";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(@Valid Evento evento, Model model,
                            RedirectAttributes redirectAttributes){

        eventoRepository.save(evento);
        redirectAttributes.addFlashAttribute("msg", "evento registrado!");
        return "redirect:/evento/cadastrar";



    }

    @GetMapping("lista")
    public String listar(Model model){
        model.addAttribute("evento", eventoRepository.findAll());
        return "evento/lista";
    }

    @GetMapping("editar/{id}")
    public String Editar(@PathVariable("id") Long id, Model model){
            model.addAttribute("evento", eventoRepository.findById(id));

            return "evento/editar";
    }


    @PostMapping("editar")
    @Transactional
    public String Editar(@Valid Evento evento, Model model,
                         RedirectAttributes redirectAttributes){
        eventoRepository.save(evento);
        redirectAttributes.addFlashAttribute("msg","evento atualizado");
        return "redirect:/evento/lista";
    }

    @PostMapping("excluir")
    @Transactional
    public String excluir(Long idEvent, RedirectAttributes redirectAttributes){
        eventoRepository.deleteById(idEvent);
        redirectAttributes.addFlashAttribute("msg", "evento removido!");
        return "redirect:/evento/lista";
    }


    @GetMapping("pesquisa")
    public String pesquisa(@RequestParam(required = false) String nome, Model model){
        if(nome == null || nome.trim().isEmpty()){
            return "evento/pesquisa";
        }


        List<Evento> resultados = eventoService.searchByTitle(nome);
        System.out.println("Número de eventos encontrados: " + resultados.size());
        model.addAttribute("resultados", resultados);
        return "evento/pesquisa";
    }
}
