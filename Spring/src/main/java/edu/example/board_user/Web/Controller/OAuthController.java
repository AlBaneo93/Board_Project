package edu.example.board_user.Web.Controller;


import edu.example.board_user.Web.DTO.KakaoTokenDTO;
import edu.example.board_user.Web.DTO.NaverTokenDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/oauth")
public class OAuthController {

  @GetMapping("/callback")
  public void callback(HttpServletRequest request) {

    for (var k : request.getParameterMap().keySet()) {
      System.out.println("value: " + k);
    }
  }

  @PostMapping("/kakao")
  public void callbackPost(@RequestBody KakaoTokenDTO tokenDTO) {
    System.out.println(tokenDTO.toString());
  }

  @PostMapping("/naver")
  public void callbackNaver(@RequestBody NaverTokenDTO tokenDTO) {
        System.out.println(tokenDTO.toString());
  }

}
