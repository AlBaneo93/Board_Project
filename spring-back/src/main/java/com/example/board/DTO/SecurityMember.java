package com.example.board.DTO;

import com.example.board.Role.MemberRole;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Getter
@Setter
public class SecurityMember extends MemberDTO {
  private static final String ROLE_PREFIX = "ROLE_";
  private static final long serialVersionUID = 1L;

  public SecurityMember(MemberDTO memberDTO) {
    // TODO
    super(memberDTO.getId(), memberDTO.getPassword(), makeGrantedAuthority(memberDTO.getRoles()));
  }

  private static List<GrantedAuthority> makeGrantedAuthority(List<MemberRole> roles){
List<GrantedAuthority> list = new ArrayList<>();
roles.forEach(role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getRoleName())));
return list;
  }
}
