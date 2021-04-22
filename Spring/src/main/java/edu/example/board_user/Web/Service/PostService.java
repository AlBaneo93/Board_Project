package edu.example.board_user.Web.Service;

import edu.example.board_user.Web.VO.Post;

import java.util.List;

public interface PostService {


  Post create(Post post);

  List<Post> findAll();

  Post find(Post post) throws Exception;

  Post update(Post post);

  void remove(Post post);

}
