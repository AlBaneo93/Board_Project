package edu.example.board_user.Web.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class AuthenticationDTO {

  private final String username;

  private final String password;

}
