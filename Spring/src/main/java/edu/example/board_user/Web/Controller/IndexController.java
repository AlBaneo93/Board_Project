package edu.example.board_user.Web.Controller;

import edu.example.board_user.Web.VO.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/index")
public class IndexController {

  @GetMapping("/hello")
  public ResponseEntity<Map<String, Object>> hello() {
    SecurityContext context = SecurityContextHolder.getContext();
    Map<String, Object> map = new HashMap<>();
    log.info(String.valueOf(context.getAuthentication()));
    map.put("result", context.getAuthentication());
    map.put("msg", "success");
    return ResponseEntity.ok(map);
  }

  @GetMapping("/admin")
//  @Secured("hasRole('ROLE_ADMIN')")
  public ResponseEntity<Map<String, Object>> admin(@AuthenticationPrincipal Member member) {
    log.info(member.toString());
    Map<String, Object> map = new HashMap<>();
    map.put("result", "admin");
    map.put("msg", "success");
    return ResponseEntity.ok(map);
  }

  @GetMapping("/manager")
//  @Secured("hasRole('ROLE_MANAGER')")
  public ResponseEntity<Map<String, Object>> manager(@AuthenticationPrincipal Member member) {
    log.info(member.toString());
    Map<String, Object> map = new HashMap<>();
    map.put("result", "manager");
    map.put("msg", "success");
    return ResponseEntity.ok(map);
  }

  @GetMapping("/user")
//  @Secured("hasRole('ROLE_USER')")
  public ResponseEntity<Map<String, Object>> user(@AuthenticationPrincipal Member member) {
    log.info(member.toString());
    Map<String, Object> map = new HashMap<>();
    map.put("result", "user");
    map.put("msg", "success");
    return ResponseEntity.ok(map);
  }

}
