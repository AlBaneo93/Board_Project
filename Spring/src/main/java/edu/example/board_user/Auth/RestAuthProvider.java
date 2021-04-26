package edu.example.board_user.Auth;

import edu.example.board_user.Exception.UserNotFoundException;
import edu.example.board_user.Web.Repostiory.MemberRepository;
import edu.example.board_user.Web.VO.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestAuthProvider implements AuthenticationProvider {

  private final MemberRepository repository;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String email = authentication.getPrincipal().toString();
    String password = authentication.getCredentials().toString();
    Member member = null;
    // 없으면 에러 발생
    try {
      member = repository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(email));
    } catch (UserNotFoundException e) {
      e.printStackTrace();
    }

    authentication.setAuthenticated(member != null);

    return authentication;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return false;
  }
}
