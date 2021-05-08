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

  // TODO: 2021-05-08  
  @JsonIgnore
  @ManyToOne
  private Post post;


  //  public void addPost(Post post) {
  //    this.post = post;
  //    post.getComments().add(this);
  //  }
  //
  //  public void removePost(Post post) {
  //    this.post = null;
  //    post.getComments().remove(this);
  //  }

}
