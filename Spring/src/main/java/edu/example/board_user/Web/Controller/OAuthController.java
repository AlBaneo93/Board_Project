package edu.example.board_user.Web.Controller;


import edu.example.board_user.Web.DTO.KakaoTokenDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class OAuthController {

  @GetMapping("/callback")
  public void callback(HttpServletRequest request) {

    for (var k : request.getParameterMap().keySet()) {
      System.out.println("value: " + k);
    }
  }

  @PostMapping("/callback")
  public void callbackPost(@RequestBody KakaoTokenDTO tokenDTO) {
    System.out.println(tokenDTO);
  }

}
