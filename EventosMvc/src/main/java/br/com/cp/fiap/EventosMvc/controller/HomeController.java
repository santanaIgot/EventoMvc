package br.com.cp.fiap.EventosMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller

public class HomeController {
    @GetMapping("Home")
    public String home(){
        return "pagina-home";
    }
}
