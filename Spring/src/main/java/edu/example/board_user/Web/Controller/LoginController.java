package edu.example.board_user.Web.Controller;

import edu.example.board_user.Auth.CustomAuthManager;
import edu.example.board_user.Web.DTO.AuthenticationDTO;
import edu.example.board_user.Web.DTO.AuthenticationToken;
import edu.example.board_user.Web.Service.MemberService;
import edu.example.board_user.Web.VO.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class LoginController {

  private final MemberService service;

  private final CustomAuthManager manager;

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody AuthenticationDTO authenticationDTO, HttpSession session) throws Exception {

    String username = authenticationDTO.getUsername();
    String password = authenticationDTO.getPassword();

    System.err.println("username: " + username + ", password: " + password);

    Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    //????
    session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
    Member member = service.find(Member.builder().email(username).build());

    return ResponseEntity.ok(new AuthenticationToken(member.getUsername(), member.getAuthorities(), session.getId()));
  }

}
