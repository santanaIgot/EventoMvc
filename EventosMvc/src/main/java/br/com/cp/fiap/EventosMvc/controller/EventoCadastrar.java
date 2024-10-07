package br.com.cp.fiap.EventosMvc.controller;

import br.com.cp.fiap.EventosMvc.model.Evento;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/evento")
public class EventoCadastrar {

    @GetMapping("/cadastrar")
    public String cadastrar(){
        return "evento/cadastrar";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(Evento evento, Model model){
            model.addAttribute("evento",evento );
            model.addAttribute("msg", "Cadastrado com sucesso!");
//

        return "evento/sucesso";
    }
}
