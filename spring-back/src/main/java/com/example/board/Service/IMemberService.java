package com.example.board.Service;

import com.example.board.DTO.MemberDTO;
import java.util.List;

public interface IMemberService {
  MemberDTO addMember(MemberDTO memberDTO);

  int updateMember(MemberDTO memberDTO);

  void deleteMember(MemberDTO memberDTO);

  MemberDTO signIn(MemberDTO memberDTO);

  MemberDTO getMember(MemberDTO memberDTO);

  List<MemberDTO> getAllMember();
}
