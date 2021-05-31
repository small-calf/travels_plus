package com.wyl.travels_plus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class TravelsPlusApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(TravelsPlusApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(builder);//打包用
    }
}
