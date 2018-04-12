package com.ucbcba.demo.services;

import com.ucbcba.demo.entities.PostCategory;

public interface PostCategoryService {
    Iterable<PostCategory> listAllPostCategorys();

    void savePostCategory(PostCategory postCategory);

    PostCategory getPostCategory(Integer id);

    void deletePostCategory(Integer id);
}


