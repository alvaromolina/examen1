package com.ucbcba.demo.repository;


import com.ucbcba.demo.entities.Post;
import com.ucbcba.demo.entities.PostCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface PostCategoryRepository extends CrudRepository<PostCategory, Integer> {

}
