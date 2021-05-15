package edu.example.board_user.Web.Service;

import edu.example.board_user.Exception.CommentNotFoundException;
import edu.example.board_user.Web.Repostiory.CommentRepository;
import edu.example.board_user.Web.VO.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService {

  private final CommentRepository repository;

  @Override
  public Comment create(Comment comment) {
    return repository.save(comment);
  }

  @Cacheable
  @Override
  public List<Comment> findAll() {
    return repository.findAll();
  }

  @Override
  public Comment find(Comment comment) throws Exception {
    return repository.findById(comment.getId()).orElseThrow(() -> new CommentNotFoundException(comment.getContent() + " Not Found"));
  }

  @CacheEvict
  @Override
  public Comment update(Comment comment) {
    return repository.save(comment);
  }

  @CacheEvict
  @Override
  public void remove(Comment comment) {
    repository.delete(comment);
  }

  @Cacheable
  @Override
  public List<Comment> pageComment(int page, int size) {
    return repository.findAll(PageRequest.of(page, size, Sort.by("id").descending())).getContent();
  }

}
