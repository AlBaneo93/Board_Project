package edu.example.board_user.Web.Service;

import edu.example.board_user.Exception.UserNotFoundException;
import edu.example.board_user.Web.Repostiory.MemberRepository;
import edu.example.board_user.Web.VO.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

  private final MemberRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    log.info("User Access at loadUserByUsername : " + username);
    return repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
  }

  @Override
  @Transactional
  public Member create(Member member) {
    return repository.save(member);
  }

  @Override
  @Transactional
  public List<Member> findAll() {
    return repository.findAll();
  }

  @Override
  @Transactional
  public Member find(Member member) throws Exception {
    return repository.findById(member.getId()).orElseThrow(() -> new UserNotFoundException(member.getId() + " Not Found"));
  }

  @Override
  @Transactional
  public Member update(Member member) {
    return repository.save(member);
  }

  @Override
  @Transactional
  public void remove(Member member) {
    repository.delete(member);
  }

}
