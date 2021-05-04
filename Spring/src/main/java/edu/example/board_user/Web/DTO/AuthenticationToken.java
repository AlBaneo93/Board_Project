package edu.example.board_user.Web.DTO;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

@Builder
@RequiredArgsConstructor
public class AuthenticationToken {

  private final String username;

  private final Collection authorities;

  private final String token;

}
