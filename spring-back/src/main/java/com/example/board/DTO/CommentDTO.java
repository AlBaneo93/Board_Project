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
    if (this.createdat == o.createdat) {
      return Integer.compare(this.level, o.level);
    }
    return Long.compare(this.createdat, o.createdat);
  }
}
