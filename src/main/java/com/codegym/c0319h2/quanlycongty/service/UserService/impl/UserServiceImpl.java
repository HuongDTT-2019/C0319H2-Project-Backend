package com.codegym.c0319h2.quanlycongty.service.UserService.impl;

import com.codegym.c0319h2.quanlycongty.model.User;
import com.codegym.c0319h2.quanlycongty.repository.UserRepository;
import com.codegym.c0319h2.quanlycongty.service.UserService.UserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Optional;

import static org.apache.commons.io.FileUtils.getFile;

@Service
@PropertySource("classpath:application.properties")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    

    @Override
    public Optional<User> findByUserName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }



}
