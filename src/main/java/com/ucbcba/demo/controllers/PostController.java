package com.ucbcba.demo.controllers;

import com.ucbcba.demo.entities.Post;
import com.ucbcba.demo.services.PostService;
import com.ucbcba.demo.services.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PostController {
    private PostService postService;

    @Autowired
    public void setPostService(PostService productService) {
        this.postService = productService;
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String list(Model model) {
        Iterable<Post> postList = postService.listAllPosts();
        model.addAttribute("variableTexto","Hello world");
        model.addAttribute("postList",postList);
        return "posts";
    }

    @RequestMapping("/newPost")
    String newPost() {
        return "newPost";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    String save(Post post) {
        postService.savePost(post);
        return "redirect:/posts";
    }

    @RequestMapping("/post/{id}")
    String show(@PathVariable Integer id, Model model) {
        Post post = postService.getPost(id);
        model.addAttribute("post", post);
        return "show";
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
