package com.example.demo;

import com.example.demo.vo.Comment;
import com.example.demo.vo.Post;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class Runner implements ApplicationRunner {

  public void test() throws ClassNotFoundException {
    Class.forName("org.mariadb.jdbc.Driver");
    try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3308/board", "root", "root")) {
      String query = "select * from post";
      ResultSet rs = connection.prepareStatement(query).executeQuery();

      List<Post> postList = new ArrayList<>();
      while (rs.next()) {
        postList.add(new Post(rs.getLong("id"), rs.getString("title"), rs.getString("content"), new HashSet<>()));
      }

      query = "select * from comment";
      rs = connection.prepareStatement(query).executeQuery();
      List<Comment> comments = new ArrayList<>();
      while (rs.next()) {
        comments.add(new Comment(rs.getLong("id"), rs.getString("content"), new Post(rs.getLong("post_id"))));
      }

      System.out.println(comments.get(0).toString());
      System.out.println();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    test();
  }

}
