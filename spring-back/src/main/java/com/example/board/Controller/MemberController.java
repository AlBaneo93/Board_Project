package com.example.board.Controller;

import com.example.board.DTO.MemberDTO;
import com.example.board.Service.IMemberService;
import com.example.board.Util.Hashing;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MemberController {
  private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
  private final IMemberService service;
  private final Hashing hashing;

  public MemberController(IMemberService service, Hashing hashing) {
    this.service = service;
    this.hashing = hashing;
  }

  @PostMapping("/signup")
  public ResponseEntity<Map<String, Object>> addMember(@RequestBody MemberDTO memberDTO) {
    Map<String, Object> map = new HashMap<>();
    try {
      map.put("msg", true);
      //      memberDTO.setPassword(hashing.getHahsResult(memberDTO.getPassword())); // 사용자 작성 해싱 코드
      // Spring security 제공 메서드 이용
      memberDTO.setPassword(new BCryptPasswordEncoder().encode(memberDTO.getPassword()));
      map.put("result", service.addMember(memberDTO));
    } catch (Exception e) {
      logger.error(e.getMessage() + " // " + e.getCause().getMessage());
      map.put("msg", false);
    }
    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @PostMapping("/signin")
  public ResponseEntity<Map<String, Object>> signIn(@RequestBody MemberDTO memberDTO) {
    Map<String, Object> map = new HashMap<>();
    try {
      map.put("msg", true);
      memberDTO.setPassword(hashing.getHahsResult(memberDTO.getPassword()));
      map.put("result", service.signIn(memberDTO));
    } catch (Exception e) {
      logger.error(e.getMessage() + " // " + e.getCause().getMessage());
      map.put("msg", false);
    }
    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @PutMapping("/member")
  public ResponseEntity<Map<String, Object>> updateMember(@RequestBody MemberDTO memberDTO) {
    Map<String, Object> map = new HashMap<>();
    try {
      map.put("msg", true);
      map.put("result", service.updateMember(memberDTO));
    } catch (Exception e) {
      logger.error(e.getMessage() + " // " + e.getCause().getMessage());
      map.put("msg", false);
    }
    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @DeleteMapping("/member")
  public ResponseEntity<Map<String, Object>> deleteMember(@RequestBody MemberDTO memberDTO) {
    Map<String, Object> map = new HashMap<>();
    try {
      service.deleteMember(memberDTO);
      map.put("msg", true);
    } catch (Exception e) {
      logger.error(e.getMessage() + " // " + e.getCause().getMessage());
      map.put("msg", false);
    }
    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @GetMapping("/member/{id}")
  public ResponseEntity<Map<String, Object>> getMember(@PathVariable("id") long id) {
    Map<String, Object> map = new HashMap<>();
    try {
      map.put("msg", true);
      map.put("result", MemberDTO.builder().id(id).build());
    } catch (Exception e) {
      logger.error(e.getMessage() + " // " + e.getCause().getMessage());
      map.put("msg", false);
    }
    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @GetMapping("/member")
  @Cacheable(cacheNames = "AllMembers")
  public ResponseEntity<Map<String, Object>> getAllMember() {
    Map<String, Object> map = new HashMap<>();
    try {
      map.put("msg", true);
      map.put("result", service.getAllMember());
    } catch (Exception e) {
      logger.error(e.getMessage() + " // " + e.getCause().getMessage());
      map.put("msg", false);
    }
    return new ResponseEntity<>(map, HttpStatus.OK);
  }
}
