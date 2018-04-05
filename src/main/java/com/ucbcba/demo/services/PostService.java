package com.ucbcba.demo.services;

import com.ucbcba.demo.entities.Post;

public interface PostService {

    Iterable<Post> listAllPosts();

    void savePost(Post post);

    Post getPost(Integer id);

    void deletePost(Integer id);

}
