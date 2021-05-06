package edu.example.board_user.Web.VO;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotBlank
  private String title;

  @NotBlank
  private String content;

  @OneToMany(mappedBy = "post")
  private Set<Comment> comments;


  public void addPost(Comment comment) {
    comments.add(comment);
    comment.setPost(this);
  }

  public void removePost(Comment comment) {
    this.comments.remove(comment);
    comment.setPost(null);
  }

}
