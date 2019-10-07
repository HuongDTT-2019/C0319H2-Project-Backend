package com.codegym.c0319h2.quanlycongty;

import com.codegym.c0319h2.quanlycongty.converter.StringToLocalDateConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class QuanlycongtyApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(QuanlycongtyApplication.class, args);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        StringToLocalDateConverter stringToLocalDateConverter = new
                StringToLocalDateConverter("MM/dd/yyyy");
        registry.addConverter(stringToLocalDateConverter);
    }
}
