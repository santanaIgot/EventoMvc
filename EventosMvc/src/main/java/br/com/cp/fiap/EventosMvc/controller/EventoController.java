package br.com.cp.fiap.EventosMvc.controller;

import br.com.cp.fiap.EventosMvc.model.Evento;

import br.com.cp.fiap.EventosMvc.repository.EventoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;
    @GetMapping("/cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("evento", new Evento());
        return "evento/cadastrar";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(Evento evento, Model model){
            eventoRepository.save(evento);
            model.addAttribute("evento",evento );
            model.addAttribute("msg", "Cadastrado com sucesso!");


        return "evento/sucesso";
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
}
