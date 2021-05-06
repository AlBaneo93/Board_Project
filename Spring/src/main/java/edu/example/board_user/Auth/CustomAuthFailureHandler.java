package edu.example.board_user.Auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Component
public class CustomAuthFailureHandler implements AuthenticationFailureHandler {

  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
    log.info("Auth Failure - ");
//    log.info(exception.getMessage());
//    log.info("----------------------------------------");

    PrintWriter writer = response.getWriter();
    writer.println("Authentication Failed");
    response.sendError(-999, "Authentication Failed in custom");
  }

}
