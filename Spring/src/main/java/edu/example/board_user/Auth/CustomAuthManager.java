package edu.example.board_user.Auth;

import edu.example.board_user.Web.Service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;


/*
* 커스텀 설정을 이용하려 로그인 처리를 진행하기 위함
* */
@Slf4j
@RequiredArgsConstructor
public class CustomAuthManager implements AuthenticationManager {

  private final MemberService service;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    log.info("------------------ AuthManager Called -------------------");
    log.info("auth principal: " + authentication.getPrincipal());
    UserDetails userDetails = service.loadUserByUsername((String) authentication.getPrincipal());

    /*각종 추가 처리 구현
     * 비번이 일치?
     * 존재하는 회원?
     * 기타 등등
     * */

    // 존재 회원 확인
    if(userDetails == null){
      log.error("User Not found Exception --- auth manager");
    }

    // 비번 일치 확인
    if(!userDetails.getPassword().equals(authentication.getCredentials()))
    {
      log.error("Authentication Exception: Not Mathcing the password");
    }


    return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
  }

}
