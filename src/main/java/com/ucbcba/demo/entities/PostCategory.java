package com.ucbcba.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class PostCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "postCategory", cascade = CascadeType.ALL)
    List<Post> posts;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Post> getPosts(){
       return  this.posts;
    }
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

}
