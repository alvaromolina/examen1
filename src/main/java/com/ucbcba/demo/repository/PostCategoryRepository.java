package com.ucbcba.demo.repository;


import com.ucbcba.demo.entities.PostCategory;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface PostCategoryRepository extends CrudRepository<PostCategory, Integer> {
}
