package edu.example.board_user.Web.Service;

import edu.example.board_user.Web.VO.Comment;

import java.util.List;

public interface CommentService {

  Comment create(Comment comment);

  List<Comment> findAll();

  Comment find(Comment comment) throws Exception;

  Comment update(Comment comment);

  void remove(Comment comment);

}
