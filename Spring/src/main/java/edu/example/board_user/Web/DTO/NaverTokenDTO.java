package edu.example.board_user.Web.DTO;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Builder
@RequiredArgsConstructor
public class NaverTokenDTO {

  private final String access_token;

  private final Long expires_in;

  private final String state;

  private final String token_type;

}
