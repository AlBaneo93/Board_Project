package edu.example.board_user.Web.DTO;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Builder
@ToString
@RequiredArgsConstructor
public class KakaoTokenDTO {

  private final String access_token;

  private final String token_type;

  private final String refresh_token;

  private final Long expires_in;

  private final String scope;

  private final Long refresh_token_expires_in;

}
