package com.example.demo.vo;

public class Comment {

  private Long id;

  private String content;

  private Post post;

  @Override
  public String toString() {
    return "Comment{" +
        "id=" + id +
        ", content='" + content + '\'' +
        ", post=" + post +
        '}';
  }

  public Comment() {
  }

  public Comment(Long id, String content, Post post) {
    this.id = id;
    this.content = content;
    this.post = post;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Post getPost() {
    return post;
  }

  public void setPost(Post post) {
    this.post = post;
  }

}
