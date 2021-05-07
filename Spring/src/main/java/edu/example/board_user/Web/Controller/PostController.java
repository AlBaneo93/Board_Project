package edu.example.board_user.Web.Controller;

import edu.example.board_user.Web.Service.PostService;
import edu.example.board_user.Web.VO.Post;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/posts")
public class PostController {

  private PostService service;

  @GetMapping("/{id}")
  public ResponseEntity<Map<String, Object>> find(@PathVariable long id) {
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

  @GetMapping("/page/{page}")
  public ResponseEntity<?> pagePost(@PathVariable("page") int page, @Value("${etc.board.size}") int size) {
    Map<String, Object> map = new HashMap<>();
    List<Post> aa = service.pagePost(page, size);
    log.info("----");
    System.out.println(aa.get(0).getComments().size());
    System.out.println(aa.get(0).getComments().get(0).toString());
    log.info("----");
    map.put("ret", aa);
    map.put("size", size);
    map.put("msg", "success");
    return ResponseEntity.ok(map);
  }

}
