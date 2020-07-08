package com.example.board.Service;

import com.example.board.DTO.BoardDTO;
import com.example.board.Exception.CommentException;
import com.example.board.Repository.BoardRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements IBoardService {

  private final BoardRepository repository;

  @Override
  public int addBoard(BoardDTO boardDTO) {
    return repository.save(boardDTO) != null ? 1 : 0;
  }

  @Override
  public int updateBoard(BoardDTO boardDTO) {
    boardDTO = repository.findById(boardDTO.getId()).get();
    return repository.save(boardDTO) != null ? 1 : 0;
  }

  @Override
  public void deleteBoard(BoardDTO boardDTO) {
    repository.delete(boardDTO);
  }

  @Override
  public BoardDTO getBoard(BoardDTO boardDTO) {
    return repository.getOne(boardDTO.getId());
  }

  @Override
  public List<BoardDTO> getBoardList() {
    return repository.findAll();
  }

}
