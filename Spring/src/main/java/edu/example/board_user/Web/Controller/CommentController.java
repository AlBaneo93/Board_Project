package edu.example.board_user.Web.Controller;

import edu.example.board_user.Web.Service.CommentService;
import edu.example.board_user.Web.VO.Comment;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
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
  public ResponseEntity<Map<String, Object>> save(@Valid @RequestBody Comment comment) {
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
  public ResponseEntity<Map<String, Object>> remove(@Valid @RequestBody Comment comment) {
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
  public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody Comment comment) {
    Map<String, Object> map = new HashMap<>();
    try {
      map.put("result", service.update(comment));
      map.put("msg", "success");
    } catch (Exception e) {
      map.put("msg", "Error Occurred");
    }
    return ResponseEntity.ok(map);
  }

@GetMapping("/page/{page}")
  public ResponseEntity<?> pagePost(@PathVariable("page") int page, @Value("${etc.board.size}") int size) {
    Map<String, Object> map = new HashMap<>();
    List<Comment> aa = service.pageComment(page, size);
    System.out.println("----");
    aa.stream().forEach(p -> System.out.println(p));
    System.out.println("----");
    map.put("ret", aa);
    map.put("cnt", size);
    map.put("msg", "success");
    return ResponseEntity.ok(map);
  }

}
