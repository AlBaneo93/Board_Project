package com.example.board.Controller;

import com.example.board.DTO.BoardDTO;
import com.example.board.DTO.CommentDTO;
import com.example.board.Service.ICommentService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CommentController {
  @Autowired private ICommentService service;

  @PostMapping("/api/comment")
  public ResponseEntity<Map<String, Object>> addComment(@RequestBody CommentDTO commentDTO) {
    Map<String, Object> map = new HashMap<>();
    try {
      map.put("msg", true);
      map.put("result", service.addComment(commentDTO));
    } catch (Exception e) {
      e.printStackTrace();
      map.put("msg", false);
    }
    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @PutMapping("/api/comment")
  public ResponseEntity<Map<String, Object>> updateComment(@RequestBody CommentDTO commentDTO) {
    Map<String, Object> map = new HashMap<>();
    try {
      map.put("msg", true);
      map.put("result", service.updateComment(commentDTO));
    } catch (Exception e) {
      e.printStackTrace();
      map.put("msg", false);
    }
    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @DeleteMapping("/api/comment")
  public ResponseEntity<Map<String, Object>> deleteComment(@RequestBody CommentDTO commentDTO) {
    Map<String, Object> map = new HashMap<>();
    try {
      service.deleteComment(commentDTO);
      map.put("msg", true);
    } catch (Exception e) {
      e.printStackTrace();
      map.put("msg", false);
    }
    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @GetMapping("/api/comment/{id}")
  public ResponseEntity<Map<String, Object>> getComment(@PathVariable("id") long id) {
    Map<String, Object> map = new HashMap<>();
    try {
      map.put("msg", true);
      map.put("result", service.getComment(CommentDTO.builder().id(id).build()));
    } catch (Exception e) {
      e.printStackTrace();
      map.put("msg", false);
    }
    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @GetMapping("/api/comment")
  public ResponseEntity<Map<String, Object>> getComment(@RequestBody BoardDTO boardDTO) {
    Map<String, Object> map = new HashMap<>();
    try {
      map.put("msg", true);
      map.put("result", service.getAllComment(boardDTO));
    } catch (Exception e) {
      e.printStackTrace();
      map.put("msg", false);
    }
    return new ResponseEntity<>(map, HttpStatus.OK);
  }
}
