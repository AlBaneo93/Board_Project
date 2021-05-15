package edu.example.board_user.Web.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Builder
@ToString
@Getter
@RequiredArgsConstructor
public class IntegratedUser {

  private final String email;

  private final String password;

  private final String name;

  private final String imgurl;

  private final String nickname;

}
