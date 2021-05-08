package edu.example.board_user.Web.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Post implements Serializable {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String title;

  @NotBlank
  private String content;

  @JoinColumn(name = "post_id")
  //  @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, targetEntity = Comment.class)
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Comment.class)
  private List<Comment> comments = new ArrayList<>();


  public void addComment(Comment comment) {
    if (comments == null)
      comments = new ArrayList<>();
    comments.add(comment);
    //    comment.setPost(this);
  }


  public void removeComment(Comment comment) {
    this.comments.remove(comment);
    //    comment.setPost(null);
  }

}
