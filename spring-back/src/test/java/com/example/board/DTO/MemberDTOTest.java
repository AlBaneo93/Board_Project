package com.example.board.DTO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MemberDTOTest {

  @Test
  void builder() {
    MemberDTO dto = MemberDTO.builder()
        .id(0)
        .email("testEmail")
        .name("testName")
        .build();

    String email = dto.getEmail();

    assertEquals("testEmail", email);
  }

  @Test
  void getName(){
    MemberDTO dto = MemberDTO.builder()
        .id(0)
        .email("testEmail")
        .name("testName")
        .build();

    String name = dto.getName();

    assertEquals("aaa", name);
  }

}