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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "board")
public class BoardDTO {

  @Id
  //  자동으로 auto increment적용
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(length = 150)
  private String title;

  @Column(length = 5000)
  private String content;

  @Column private long uid;

  @Column(length = 30)
  private String name;

  @Column private long createdat;
}
