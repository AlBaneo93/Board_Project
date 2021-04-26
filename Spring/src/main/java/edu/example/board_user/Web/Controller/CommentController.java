package edu.example.board_user.Web.Controller;

import edu.example.board_user.Web.Service.CommentService;
import edu.example.board_user.Web.VO.Comment;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {

  private CommentService service;

  @GetMapping("/{id}")
  public ResponseEntity<Map<String, Object>> find(@RequestParam long id) {
    Map<String, Object> map = new HashMap<>();
    try {
      map.put("result", service.find(Comment.builder().id(id).build()));
      map.put("msg", "success");
    } catch (Exception e) {
      map.put("msg", "Error Occurred");
    }
    return ResponseEntity.ok(map);
  }

  @GetMapping("/findall")
  public ResponseEntity<Map<String, Object>> findAll() {
    Map<String, Object> map = new HashMap<>();
    try {
      map.put("result", service.findAll());
      map.put("msg", "success");
    } catch (Exception e) {
      map.put("msg", "Error Occurred");
    }
    return ResponseEntity.ok(map);
  }

  @PostMapping
  public ResponseEntity<Map<String, Object>> save(Comment comment) {
    Map<String, Object> map = new HashMap<>();
    try {
      map.put("result", service.create(comment));
      map.put("msg", "success");
    } catch (Exception e) {
      map.put("msg", "Error Occurred");
    }
    return ResponseEntity.ok(map);
  }

  @DeleteMapping
  public ResponseEntity<Map<String, Object>> remove(Comment comment) {
    Map<String, Object> map = new HashMap<>();
    try {
      service.remove(comment);
      map.put("msg", "success");
    } catch (Exception e) {
      map.put("msg", "Error Occurred");
    }
    return ResponseEntity.ok(map);
  }

  @PutMapping
  public ResponseEntity<Map<String, Object>> update(Comment comment) {
    Map<String, Object> map = new HashMap<>();
    try {
      map.put("result", service.update(comment));
      map.put("msg", "success");
    } catch (Exception e) {
      map.put("msg", "Error Occurred");
    }
    return ResponseEntity.ok(map);
  }

}
