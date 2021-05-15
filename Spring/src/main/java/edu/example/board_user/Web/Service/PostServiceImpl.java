package edu.example.board_user.Web.Service;

import edu.example.board_user.Exception.PostNotFoundException;
import edu.example.board_user.Web.Repostiory.PostRepository;
import edu.example.board_user.Web.VO.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

  private final PostRepository repository;

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

  @Override
  public List<Post> pagePost(int page, int size) {
    // page당 size크기만큼 뽑게 되는데, 몇번 째 page를 받을 지 전달받음
    return repository.findAll(PageRequest.of(page, size, Sort.by("id").descending())).getContent();
  }

}
