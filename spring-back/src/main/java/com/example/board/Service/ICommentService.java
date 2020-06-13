package com.example.board.Service;

import com.example.board.DTO.BoardDTO;
import com.example.board.DTO.CommentDTO;
import java.util.List;

public interface ICommentService {

  CommentDTO addComment(CommentDTO commentDTO);

  CommentDTO updateComment(CommentDTO commentDTO);

  void deleteComment(CommentDTO commentDTO);

  CommentDTO getComment(CommentDTO commentDTO);

  List<CommentDTO> getAllComment(BoardDTO boardDTO);
}