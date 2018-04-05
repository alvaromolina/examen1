package com.ucbcba.demo.services;

import com.ucbcba.demo.entities.Post;
import com.ucbcba.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    @Qualifier(value = "postRepository")
    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public Iterable<Post> listAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public void savePost(Post post) {
        postRepository.save(post);
    }

    @Override
    public Post getPost(Integer id) {
        return postRepository.findById(id).get();
    }

    @Override
    public void deletePost(Integer id) {
        postRepository.deleteById(id);;
    }
}
