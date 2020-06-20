package com.example.board.Util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.stereotype.Component;

@Component
public class Hashing {
  public String getHahsResult(String content) {
    StringBuffer sb = new StringBuffer();
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      byte[] hashReuslt = md.digest(content.getBytes(StandardCharsets.UTF_8));
      for (Byte data : hashReuslt) {
        // TODO : 얘네가 뜻하는 것은?
        sb.append(Integer.toString((data & 0xff) + 0x100, 16).substring(1));
      }
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return sb.toString();
  }
}
