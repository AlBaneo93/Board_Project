package edu.example.board_user.Web.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String content;

  @ManyToOne
  private Post post;


  public void addPost(Post post) {
    this.post = post;
    post.getComments().add(this);
  }

  public void removePost(Post post) {
    this.post = null;
    post.getComments().remove(this);
  }

}
