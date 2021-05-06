package edu.example.board_user.Auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

@Slf4j
public class CustomAuthenticationFilter extends AbstractAuthenticationProcessingFilter {


  public CustomAuthenticationFilter(String defaultFilterProcessesUrl) {
    super(defaultFilterProcessesUrl);
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
    // post로 보낸 데이터를 받을때 사용
    // 그러나 postman을 통해 raw data로 보내면 값을 읽어들이지 못함
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    //    log.info("Authentication Manager Name : " + getAuthenticationManager().getClass().getName());
    //    log.info(this.getClass().getName() + "     ----     username: " + username + ", password: " + password + " loged in");

    // 객체 생성시 설정해준 매니저를 이용
    return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(username, password));
  }

}
