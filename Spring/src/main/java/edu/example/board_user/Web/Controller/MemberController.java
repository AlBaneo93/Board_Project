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
import java.util.List;
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
    log.info("finall methods called");
    Map<String, Object> map = new HashMap<>();
    try {
      List<Member> MemberList = service.findAll();
      map.put("result", MemberList.size() == 0 ? "there is no result" : MemberList);
      map.put("msg", "success");
    } catch (Exception e) {
      map.put("msg", "Error Occurred");
    }
    return ResponseEntity.ok(map);
  }

  @PostMapping
  public ResponseEntity<Map<String, Object>> signUp(@RequestBody Member member) {

    Map<String, Object> map = new HashMap<>();
    try {
      member.setCreatedAt(new Date());
      member.setPassword(passwordEncoder.encode(member.getPassword()));
      member.setEnabled(true);
      map.put("result", service.create(member));
      map.put("msg", "success");
    } catch (Exception e) {
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

  @GetMapping("/admin")
  public ResponseEntity<Map<String, Object>> isAdmin() {
    Map<String, Object> map = new HashMap<>();
//    log.info("isAdmin : " + member.toString());
    map.put("result", "Your are a Admin!");
    map.put("msg", "success");
    return ResponseEntity.ok(map);
  }

}
