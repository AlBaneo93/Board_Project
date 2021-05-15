package edu.example.board_user.Web.Controller;


import edu.example.board_user.Web.DTO.KakaoTokenDTO;
import edu.example.board_user.Web.DTO.NaverTokenDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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
  public ResponseEntity<Map<String, Object>> callbackPost(@RequestBody KakaoTokenDTO tokenDTO) {
    String url = "https://kapi.kakao.com/v2/user/me";
    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Bearer " + tokenDTO.getAccess_token());
    HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(headers);
    ResponseEntity entity = new RestTemplate().exchange(url, HttpMethod.POST, httpEntity, Map.class);
    Map tmp = (Map) entity.getBody();
    //    for (var key : tmp.keySet())
    //      System.out.println("key: " + key + ", value: " + tmp.get(key));

    Map<String, Object> map = new HashMap<>();
    map.put("res", tmp.get("kakao_account"));
    System.out.println(map);
    return ResponseEntity.ok(map);
  }

  @PostMapping("/naver")
  public ResponseEntity<Map<String, Object>> callbackNaver(@RequestBody NaverTokenDTO tokenDTO) {
    System.out.println(tokenDTO.toString());
    // TODO: 2021-05-14 : naver 유저 정보를 가져와서 프론트로 보내기
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://openapi.naver.com/v1/nid/me";
    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Bearer " + tokenDTO.getAccess_token());

    HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(headers);
    ResponseEntity entity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);
    Map tmp = (Map) entity.getBody();
    Map<String, Object> map = new HashMap<>();
    map.put("res", tmp.get("response"));

    return ResponseEntity.ok(map);
  }

}
