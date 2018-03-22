package com.ucbcba.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloWorldController {

    @RequestMapping("/")
    String hello() {
        return "Hello, World";
    }

    @RequestMapping("/listar")
    String listar() {
        return "Aca voy a mostrar un listado";
    }
}