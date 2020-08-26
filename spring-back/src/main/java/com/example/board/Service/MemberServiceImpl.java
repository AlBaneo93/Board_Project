package com.example.board.Service;

import com.example.board.DTO.MemberDTO;
import com.example.board.Repository.MemberRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements IMemberService, UserDetailsService {
  private final MemberRepository repository;

  @Override
  public MemberDTO addMember(MemberDTO memberDTO) {
    return repository.save(memberDTO);
  }

  @Override
  public int updateMember(MemberDTO memberDTO) {
    memberDTO = repository.getOne(memberDTO.getId());
    return repository.save(memberDTO) != null ? 1 : 0;
  }

  @Override
  public void deleteMember(MemberDTO memberDTO) {
    repository.delete(memberDTO);
  }

  @Override
  public MemberDTO signIn(MemberDTO memberDTO) {
    return repository.findByEmailAndPassword(memberDTO.getEmail(), memberDTO.getPassword()).get();
  }

  @Override
  public MemberDTO getMember(MemberDTO memberDTO) {
    return repository.getOne(memberDTO.getId());
  }

  @Override
  public List<MemberDTO> getAllMember() {
    return repository.findAll();
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    TODO
    return null;
  }
}
