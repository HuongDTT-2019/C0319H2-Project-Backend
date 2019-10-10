package com.codegym.c0319h2.quanlycongty.converter;

import com.codegym.c0319h2.quanlycongty.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class UserMapper {
    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    public User readJsonWithObjectMapper() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        User user = objectMapper.readValue(new File("user.json"), User.class);

        logger.info(user.toString());

        return user;

    }
}
