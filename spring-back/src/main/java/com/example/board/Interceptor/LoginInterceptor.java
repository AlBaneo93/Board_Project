package com.example.board.Interceptor;

import com.example.board.DTO.ErrorResponseDTO;
import com.example.board.DTO.MemberDTO;
import com.example.board.Service.IJwtService;
import com.example.board.Service.IMemberService;
import com.example.board.Util.Hashing;
import com.example.board.Wrapper.RequestWrapper;
import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

  private final Hashing hashing;
  private final IMemberService memberService;
  private final IJwtService jwtService;

  //  생성자를 이용한 DI
  public LoginInterceptor(Hashing hashing, IMemberService memberService, IJwtService jwtService) {
    this.hashing = hashing;
    this.memberService = memberService;
    this.jwtService = jwtService;
  }

  private String getJsonObject(Object obj) {
    Gson gson = new Gson();
    return gson.toJson(obj);
  }

  private void sendErrorResponse(ErrorResponseDTO responseDTO, OutputStream out) {
    BufferedWriter bw = null;
    try {
      bw = new BufferedWriter(new OutputStreamWriter(out));
      bw.write(getJsonObject(responseDTO));
    } catch (IOException e) {
      e.printStackTrace();
      //      change to logging system
      System.out.println("Response Error");
    }
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    //    TODO : complete to implement the login interceptor

    MemberDTO memberDTO =
        getUserDataFromRequestBody(
            new RequestWrapper(request));

    if ((memberDTO = memberService.signIn(memberDTO)) == null) {
      System.out.println("유저 인증 실패");

      return false;
    }

    if (jwtService.isValidation(memberDTO.getAccessToken(), true, memberDTO)) {
      System.out.println("액세스 토큰 인증 실패");
      return false;
    }
    if (jwtService.isValidation(memberDTO.getRefreshToken(), false, memberDTO)) {
      System.out.println("리프레시 토큰 인증 실패");
      return false;
    }

    return true;
  }

  private MemberDTO getUserDataFromRequestBody(HttpServletRequestWrapper request) {
    return MemberDTO.builder()
        .email(request.getParameter("email"))
        .password(hashing.getHahsResult(request.getParameter("password")))
        .build();
  }
}
