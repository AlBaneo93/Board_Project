package edu.example.board_user.Web.Service;

import edu.example.board_user.Exception.UserNotFoundException;
import edu.example.board_user.Web.VO.Member;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface MemberService extends UserDetailsService {

  @Override
  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

  Member create(Member member);

  List<Member> findAll();

  Member find(Member member) throws UserNotFoundException, Exception;

  Member update(Member member);

  void remove(Member member);

}
