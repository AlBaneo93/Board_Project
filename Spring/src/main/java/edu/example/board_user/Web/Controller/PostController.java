package edu.example.board_user.Web.Controller;

import edu.example.board_user.Web.Service.PostService;
import edu.example.board_user.Web.VO.Post;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/posts")
public class PostController {

  private PostService service;

  @GetMapping("/{id}")
  public ResponseEntity<Map<String, Object>> find(@RequestParam long id) {
    Map<String, Object> map = new HashMap<>();
    try {
      map.put("result", service.find(Post.builder().id(id).build()));
      map.put("msg", "success");
    } catch (Exception e) {
      map.put("msg", "Error Occurred");
    }
    return ResponseEntity.ok(map);
  }

  @GetMapping
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
  public ResponseEntity<Map<String, Object>> save(Post post) {
    Map<String, Object> map = new HashMap<>();
    try {
      map.put("result", service.create(post));
      map.put("msg", "success");
    } catch (Exception e) {
      map.put("msg", "Error Occurred");
    }
    return ResponseEntity.ok(map);
  }

  @DeleteMapping
  public ResponseEntity<Map<String, Object>> remove(Post post) {
    Map<String, Object> map = new HashMap<>();
    try {
      service.remove(post);
      map.put("msg", "success");
    } catch (Exception e) {
      map.put("msg", "Error Occurred");
    }
    return ResponseEntity.ok(map);
  }

  @PutMapping
  public ResponseEntity<Map<String, Object>> update(Post post) {
    Map<String, Object> map = new HashMap<>();
    try {
      map.put("result", service.update(post));
      map.put("msg", "success");
    } catch (Exception e) {
      map.put("msg", "Error Occurred");
    }
    return ResponseEntity.ok(map);
  }

}
