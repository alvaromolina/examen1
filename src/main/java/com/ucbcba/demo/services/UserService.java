package com.ucbcba.demo.services;

import com.ucbcba.demo.entities.Comment;
import com.ucbcba.demo.entities.User;

public interface UserService {

    Iterable<User> listAllUsers();

}
