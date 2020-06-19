package com.example.board.DTO;

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
@Entity(name = "comment")
public class CommentDTO implements Comparable<CommentDTO> {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String comment;

  //  솔직히 uid는 노필요 일것 같은데
  private long uid;

  private String name;

  private long boardid;

  private int level;

  //  상위 레벨의 comment id
  private long appendto;

  private long createdat;

  @Override
  public int compareTo(CommentDTO o) {
    if (this.createdat < o.createdat) {
      return -1;
    } else if (this.createdat == o.createdat) {
      return Integer.compare(this.level, o.level);
    }
    return 1;
  }

  //  현재 댓글이 갖고있는 답글
  //  얘를 jpa로 어떻게 집어넣지
  //  @Transient private List<CommentDTO> reply;
}
