package one.digitalinnovation.personapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping
    private String helloWorld() {
        return "Olá Heroku! Sou a aplicação Olho no Preço!";
    }

}
