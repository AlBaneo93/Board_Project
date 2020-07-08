package com.example.board.Controller;

import com.example.board.DTO.BoardDTO;
import com.example.board.Service.IBoardService;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BoardController {
  private final IBoardService service;
  private Logger logger = LoggerFactory.getLogger(BoardController.class);

  public BoardController(IBoardService service) {
    this.service = service;
  }

  @PostMapping("/board")
  public ResponseEntity<Map<String, Object>> addBoard(@RequestBody BoardDTO boardDTO) {
    Map<String, Object> map = new HashMap<String, Object>();
    try {
      map.put("msg", true);
      map.put("result", service.addBoard(boardDTO));
    } catch (Exception e) {
      logger.error(e.getMessage() + " // "+ e.getCause().getMessage());
      map.put("msg", false);
    }
    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @PutMapping("/board")
  public ResponseEntity<Map<String, Object>> updateBoard(@RequestBody BoardDTO boardDTO) {
    Map<String, Object> map = new HashMap<String, Object>();
    try {
      map.put("msg", true);
      map.put("result", service.updateBoard(boardDTO));
    } catch (Exception e) {
      logger.error(e.getMessage() + " // "+ e.getCause().getMessage());
      map.put("msg", false);
    }
    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @DeleteMapping("/board")
  public ResponseEntity<Map<String, Object>> deleteBoard(@RequestBody BoardDTO boardDTO) {
    Map<String, Object> map = new HashMap<String, Object>();
    try {
      map.put("msg", true);
      service.deleteBoard(boardDTO);
    } catch (Exception e) {
      logger.error(e.getMessage() + " // "+ e.getCause().getMessage());
      map.put("msg", false);
    }
    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @GetMapping("/board/{id}")
  public ResponseEntity<Map<String, Object>> getBoard(@PathVariable("id") long id) {
    Map<String, Object> map = new HashMap<String, Object>();
    try {
      map.put("msg", true);
      map.put("result", service.getBoard(BoardDTO.builder().id(id).build()));
    } catch (Exception e) {
      logger.error(e.getMessage() + " // "+ e.getCause().getMessage());
      map.put("msg", false);
    }
    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @GetMapping("/board")
  @Cacheable
  public ResponseEntity<Map<String, Object>> getBoardList() {
    Map<String, Object> map = new HashMap<String, Object>();
    try {
      map.put("msg", true);
      map.put("result", service.getBoardList());
    } catch (Exception e) {
      logger.error(e.getMessage() + " // "+ e.getCause().getMessage());
      map.put("msg", false);
    }
    return new ResponseEntity<>(map, HttpStatus.OK);
  }
}
