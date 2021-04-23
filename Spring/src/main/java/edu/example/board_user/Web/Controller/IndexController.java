package edu.example.board_user.Web.Controller;

import edu.example.board_user.Web.VO.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/index")
public class IndexController {

  @PostMapping("/admin")
  @Secured("hasRole('ROLE_ADMIN')")
  public ResponseEntity<Map<String, Object>> admin(@AuthenticationPrincipal Member member) {
    log.info(member.toString());
    Map<String, Object> map = new HashMap<>();
    map.put("result", "admin");
    map.put("msg", "success");
    return ResponseEntity.ok(map);
  }

  @PostMapping("/manager")
  @Secured("hasRole('ROLE_MANAGER')")
  public ResponseEntity<Map<String, Object>> manager(@AuthenticationPrincipal Member member) {
    log.info(member.toString());
    Map<String, Object> map = new HashMap<>();
    map.put("result", "manager");
    map.put("msg", "success");
    return ResponseEntity.ok(map);
  }

  @PostMapping("/user")
  @Secured("hasRole('ROLE_USER')")
  public ResponseEntity<Map<String, Object>> user(@AuthenticationPrincipal Member member) {
    log.info(member.toString());
    Map<String, Object> map = new HashMap<>();
    map.put("result", "user");
    map.put("msg", "success");
    return ResponseEntity.ok(map);
  }

}
