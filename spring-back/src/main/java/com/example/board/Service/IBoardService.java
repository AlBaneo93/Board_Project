package com.example.board.Service;

import com.example.board.DTO.BoardDTO;
import java.util.List;

public interface IBoardService {
  int addBoard(BoardDTO boardDTO);

  int updateBoard(BoardDTO boardDTO);

  void deleteBoard(BoardDTO boardDTO);

  BoardDTO getBoard(BoardDTO boardDTO);

  List<BoardDTO> getBoardList();
}
