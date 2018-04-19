package com.ucbcba.demo.controllers;

import com.ucbcba.demo.entities.Comment;
import com.ucbcba.demo.entities.Post;
import com.ucbcba.demo.entities.PostCategory;
import com.ucbcba.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PostController {
    private PostService postService;
    private PostCategoryService postCategoryService;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setPostService(PostService productService) {
        this.postService = productService;
    }

    @Autowired
    public void setPostCategoryService(PostCategoryService postCategoryService) {
        this.postCategoryService = postCategoryService;
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String list(Model model) {
        Iterable<Post> postList = postService.listAllPosts();
        model.addAttribute("variableTexto","Hello world");
        model.addAttribute("postList",postList);
        return "posts";
    }

    @RequestMapping("/newPost")
    String newPost(Model model) {
        Iterable<PostCategory> postCategories = postCategoryService.listAllPostCategorys();
        model.addAttribute("postCategories", postCategories);
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
        model.addAttribute("userList", userService.listAllUsers());
        model.addAttribute("post", post);
        return "show";
    }

    @RequestMapping("/editPost/{id}")
    String editPost(@PathVariable Integer id, Model model) {
        Post post = postService.getPost(id);
        model.addAttribute("post", post);
        Iterable<PostCategory> postCategories = postCategoryService.listAllPostCategorys();
        model.addAttribute("postCategories", postCategories);
        return "editPost";
    }

    @RequestMapping("/deletePost/{id}")
    String delete(@PathVariable Integer id) {
        postService.deletePost(id);
        return "redirect:/posts";
    }

    @RequestMapping("/like/{id}")
    String like(@PathVariable Integer id) {
        Post post = postService.getPost(id);
        post.setLikes(post.getLikes()+1);
        postService.savePost(post);
        return "redirect:/post/"+post.getId();
    }
}
