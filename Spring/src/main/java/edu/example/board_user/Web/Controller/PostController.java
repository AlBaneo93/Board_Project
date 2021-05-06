package edu.example.board_user.Web.Controller;

import edu.example.board_user.Web.Service.PostService;
import edu.example.board_user.Web.VO.Post;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
  public ResponseEntity<Map<String, Object>> save(@Valid @RequestBody Post post) {
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
  public ResponseEntity<Map<String, Object>> remove(@Valid @RequestBody Post post) {
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
  public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody Post post) {
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
