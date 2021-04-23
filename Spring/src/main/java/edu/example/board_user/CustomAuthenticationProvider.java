package edu.example.board_user;

import edu.example.board_user.Web.Service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;


@AllArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

  private PasswordEncoder passwordEncoder;

  private MemberService service;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String email = authentication.getName();
    String pass = passwordEncoder.encode(authentication.getCredentials().toString());

//    Member member = service.find(Member.builder().email(email).password(pass).build());

    return null;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return false;
  }

}
