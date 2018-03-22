package com.ucbcba.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PostController {

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("variableTexto","Hello world");
        return "posts";
    }

    @RequestMapping("/newPost")
    String newPost() {

        return "Aca voy a mostrar un formulario";
    }

    @RequestMapping("/savePost")
    String save() {
        return "Aca voy a guardar el post";
    }

    @RequestMapping("/post/{id}")
    String show(@PathVariable Integer id) {
        // Recuperar de la BD el post con Id = id
        return "Aca voya mostrar el post" + id;
    }

    @RequestMapping("/editPost/{id}")
    String editPost(@PathVariable Integer id) {
        return "Aca voy a editar el post" + id;
    }

    @RequestMapping("/post/delete")
    String delete() {
        return "Hello, World";
    }
}
