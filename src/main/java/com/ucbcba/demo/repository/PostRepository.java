package com.ucbcba.demo.repository;

import com.ucbcba.demo.entities.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface PostRepository extends CrudRepository<Post, Integer> {

    @Query("select p from Post p where p.text like %:text%")
    Iterable<Post> getPostsLikeText(@Param("text") String text);

}
