package com.example.board.Service;

import com.example.board.DTO.BoardDTO;
import com.example.board.DTO.CommentDTO;
import com.example.board.Repository.CommentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements ICommentService {
  @Autowired private CommentRepository repository;

  @Override
  public CommentDTO addComment(CommentDTO commentDTO) {
    return repository.save(commentDTO);
  }

  @Override
  public CommentDTO updateComment(CommentDTO commentDTO) {
    return repository.save(repository.getOne(commentDTO.getId()));
  }

  @Override
  public void deleteComment(CommentDTO commentDTO) {
    repository.delete(commentDTO);
  }

  @Override
  public CommentDTO getComment(CommentDTO commentDTO) {
    return repository.getOne(commentDTO.getId());
  }

  @Override
  public List<CommentDTO> getAllComment(BoardDTO boardDTO) {
    return repository.findAllByBoardid(boardDTO.getId());
  }
}