package br.com.cp.fiap.EventosMvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {
    @GetMapping("Home")
    public String home(){
        return "pagina-home";
    }
}
