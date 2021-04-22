package edu.example.board_user.Web.Service;

import edu.example.board_user.Exception.PostNotFoundException;
import edu.example.board_user.Web.Repostiory.PostRepository;
import edu.example.board_user.Web.VO.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PostServiceImpl implements PostService {

  private PostRepository repository;

  @Override
  public Post create(Post post) {
    return repository.save(post);
  }

  @Override
  public List<Post> findAll() {
    return repository.findAll();
  }

  @Override
  public Post find(Post post) throws Exception {
    return repository.findById(post.getId()).orElseThrow(() -> new PostNotFoundException(""));
  }

  @Override
  public Post update(Post post) {
    return repository.save(post);
  }

  @Override
  public void remove(Post post) {
    repository.delete(post);
  }

}
