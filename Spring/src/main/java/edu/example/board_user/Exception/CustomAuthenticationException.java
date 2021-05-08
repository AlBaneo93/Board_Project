package edu.example.board_user.Exception;

import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationException extends AuthenticationException {

  public CustomAuthenticationException(String msg, Throwable cause) {
    super(msg, cause);
  }

  public CustomAuthenticationException(String msg) {
    super(msg);
  }

}
