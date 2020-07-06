package com.example.board_image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class BoardImageApplication {

    @Autowired
    Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(BoardImageApplication.class, args);

    }

}
