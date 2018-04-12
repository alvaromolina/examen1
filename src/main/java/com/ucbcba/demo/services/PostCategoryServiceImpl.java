package com.ucbcba.demo.services;


import com.ucbcba.demo.entities.PostCategory;
import com.ucbcba.demo.repository.PostCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PostCategoryServiceImpl implements PostCategoryService {
    private PostCategoryRepository postCategoryRepository;

    @Autowired
    @Qualifier(value = "postCategoryRepository")
    public void setPostCategoryRepository(PostCategoryRepository postCategoryRepository) {
        this.postCategoryRepository = postCategoryRepository;
    }


    @Override
    public Iterable<PostCategory> listAllPostCategorys() {
        return postCategoryRepository.findAll();
    }

    @Override
    public void savePostCategory(PostCategory postCategory) {
        postCategoryRepository.save(postCategory);
    }

    @Override
    public PostCategory getPostCategory(Integer id) {
        return postCategoryRepository.findById(id).get();
    }

    @Override
    public void deletePostCategory(Integer id) {
        postCategoryRepository.deleteById(id);;
    }
}
