package com.example.board.Service;

import com.example.board.DTO.MemberDTO;
import java.io.UnsupportedEncodingException;

public interface IJwtService {
  boolean isValidation(String token, boolean type, MemberDTO memberDTO);

  String getAccessToken(MemberDTO memberDTO) throws UnsupportedEncodingException;

  String getRefreshToken(MemberDTO memberDTO) throws UnsupportedEncodingException;
}
