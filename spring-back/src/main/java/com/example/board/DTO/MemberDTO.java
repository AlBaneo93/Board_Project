package com.example.board.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "member")
public class MemberDTO {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(length = 30, unique = true)
  private String email;

  @Column(length = 30, nullable = false)
  private String name;

  @Column(length = 150)
  private String password;

  @Column(length = 200)
  private String accessToken;

  @Column(length = 200)
  private String refreshToken;
}
