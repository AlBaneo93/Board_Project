package edu.example.board_user.Web.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String title;

  private String content;

  @OneToMany(mappedBy = "post")
  private Set<Comment> comments;

  public void addPost(Comment comment) {
    this.comments.add(comment);
    comment.setPost(this);
  }

  public void removePost(Comment comment) {
    this.comments.remove(comment);
    comment.setPost(null);
  }

}
