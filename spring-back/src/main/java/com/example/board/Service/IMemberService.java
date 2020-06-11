package com.example.board.Service;

import com.example.board.DTO.MemberDTO;
import java.util.List;

public interface IMemberService {
  int addMember(MemberDTO memberDTO);

  int updateMember(MemberDTO memberDTO);

  void deleteMember(MemberDTO memberDTO);

  MemberDTO getMember(MemberDTO memberDTO);

  List<MemberDTO> getAllMember();
}
