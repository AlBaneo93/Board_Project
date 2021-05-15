package com.example.demo.vo;


import java.util.Set;

public class Post {

  private Long id;

  private String title;

  private String content;

  private Set<Comment> comments;

  public Post(Long id) {
    this.id = id;
  }

  public Post() {
  }

  public Post(Long id, String title, String content, Set<Comment> comments) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.comments = comments;
  }

  @Override
  public String toString() {
    return "Post{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", content='" + content + '\'' +
        ", comments=" + comments +
        '}';
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Set<Comment> getComments() {
    return comments;
  }

  public void setComments(Set<Comment> comments) {
    this.comments = comments;
  }

}
