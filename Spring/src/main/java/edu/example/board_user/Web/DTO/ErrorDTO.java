package edu.example.board_user.Web.DTO;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class ErrorDTO {

  private final String message;
  private final Long code;
  private final String reason;
}
