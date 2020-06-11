package com.example.board.Service;

import com.example.board.DTO.MemberDTO;
import com.example.board.Repository.MemberRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements IMemberService {
  @Autowired private MemberRepository repository;

  @Override
  public int addMember(MemberDTO memberDTO) {
    return repository.save(memberDTO) != null ? 1 : 0;
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
  public MemberDTO getMember(MemberDTO memberDTO) {
    return repository.getOne(memberDTO.getId());
  }

  @Override
  public List<MemberDTO> getAllMember() {
    return repository.findAll();
  }
}
