package edu.example.board_user.Web.VO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@ToString(exclude = "post")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String content;

  private Long parent;

  private int depth;

  // TODO: 2021-05-08  
  @JsonIgnore
  @ManyToOne
  private Post post;

}
