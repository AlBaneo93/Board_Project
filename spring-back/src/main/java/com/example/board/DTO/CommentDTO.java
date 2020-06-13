package com.example.board.DTO;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "comment")
public class CommentDTO {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String comment;

  private long uid;

  private long boardid;

  private int level;

  //  상위 레벨의 comment id
  private long appendto;

  private long createdat;

  //  현재 댓글이 갖고있는 답글
  //  얘를 jpa로 어떻게 집어넣지
  @Transient private List<CommentDTO> reply;
}
