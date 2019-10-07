package com.codegym.c0319h2.quanlycongty.service.UserService;

import com.codegym.c0319h2.quanlycongty.model.User;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Optional;

public interface UserService {
    Optional<User> findByUserName(String name);

    void save(User user);


}
