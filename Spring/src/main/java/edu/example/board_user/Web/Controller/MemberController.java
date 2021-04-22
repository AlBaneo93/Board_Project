package edu.example.board_user.Web.Controller;

import edu.example.board_user.Web.Service.MemberService;
import edu.example.board_user.Web.VO.Member;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/member")
public class MemberController {

  private MemberService service;

  private PasswordEncoder passwordEncoder;

  @GetMapping("/{id}")
  public ResponseEntity<Map<String, Object>> find(@RequestParam Long id) {
    Map<String, Object> map = new HashMap<>();
    try {
      map.put("result", service.find(Member.builder().id(id).build()));
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
  public ResponseEntity<Map<String, Object>> signUp(@RequestBody Member member) {
    log.info("User Access to create User");
    log.info(member.toString());
    Map<String, Object> map = new HashMap<>();
    try {
      member.setCreatedAt(new Date());
      member.setPassword(passwordEncoder.encode(member.getPassword()));
      member.setEnabled(true);
      log.debug("Member Info: " + member.toString());
      map.put("result", service.create(member));
      map.put("msg", "success");
    } catch (Exception e) {
      log.debug(e.getMessage());
      map.put("msg", "Error Occurred");
    }
    return ResponseEntity.ok(map);
  }

  @DeleteMapping
  public ResponseEntity<Map<String, Object>> remove(Member member) {
    Map<String, Object> map = new HashMap<>();
    try {
      service.remove(member);
      map.put("msg", "success");
    } catch (Exception e) {
      map.put("msg", "Error Occurred");
    }
    return ResponseEntity.ok(map);
  }

  @PutMapping
  public ResponseEntity<Map<String, Object>> update(Member member) {
    Map<String, Object> map = new HashMap<>();
    try {
      map.put("result", service.update(member));
      map.put("msg", "success");
    } catch (Exception e) {
      map.put("msg", "Error Occurred");
    }
    return ResponseEntity.ok(map);
  }

}
