package edu.example.board_user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@Slf4j
@EnableCaching
@SpringBootApplication
public class BoardUserApplication {

  public static void main(String[] args) {
    SpringApplication.run(BoardUserApplication.class, args);
  }
}
