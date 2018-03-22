package com.ucbcba.demo.repository;

import com.ucbcba.demo.entities.Post;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface PostRepository extends CrudRepository<Post, Integer> {

}
