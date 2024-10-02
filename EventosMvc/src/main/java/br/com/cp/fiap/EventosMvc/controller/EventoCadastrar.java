package br.com.cp.fiap.EventosMvc.controller;

import br.com.cp.fiap.EventosMvc.model.Evento;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evento")
public class EventoCadastrar {
    @GetMapping("/cadastrar")
    public String cadastrar(){
        return "evento/cadastrar";
    }

    @PostMapping("cadastrar")
    public String cadastrar(Evento evento){
        System.out.println(evento.getNome());

        return "evento/sucesso";
    }
}
