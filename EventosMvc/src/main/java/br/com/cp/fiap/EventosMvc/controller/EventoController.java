package br.com.cp.fiap.EventosMvc.controller;

import br.com.cp.fiap.EventosMvc.model.Evento;

import br.com.cp.fiap.EventosMvc.repository.EventoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
