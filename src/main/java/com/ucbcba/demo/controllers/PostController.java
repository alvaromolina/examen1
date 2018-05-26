package com.ucbcba.demo.controllers;

import com.ucbcba.demo.entities.Comment;
import com.ucbcba.demo.entities.Post;
import com.ucbcba.demo.entities.PostCategory;
import org.springframework.security.core.userdetails.User;
import com.ucbcba.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
    public String list(@RequestParam(value = "text", required = false, defaultValue="") String text , Model model) {


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User u = (org.springframework.security.core.userdetails.User)auth.getPrincipal();
        com.ucbcba.demo.entities.User user = userService.findByUsername(u.getUsername());

        Iterable<Post> postList;
        if(text.equals("")){
            postList = postService.listAllPosts();

        }else{
            System.out.println("filtro" +text);

            postList = postService.getPostsLikeText(text);
        }
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


    @RequestMapping(value = "/buscar/{category_id}")
    String buscar(@PathVariable Integer category_id, Model model) {
        PostCategory postCategory = postCategoryService.getPostCategory(category_id);
        List<Post> posts = postCategory.getPosts();
        model.addAttribute("posts",posts);
        return "buscar";
    }

    @RequestMapping(value = "/buscarTexto/{text}")
    String buscarByTexto(@PathVariable String text, Model model) {
        Iterable<Post> postList = postService.getPostsLikeText(text);
        model.addAttribute("postList",postList);
        return "buscar";
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
