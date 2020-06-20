package com.example.board.Service;

import com.example.board.DTO.MemberDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.SignatureException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl implements IJwtService {

  @Value("${jwt.auth.refreshsecret}")
  private String refreshSecret;

  @Value("${jwt.auth.accesssecret}")
  private String accessSecret;

  @Value("${jwt.auth.accessexpires}")
  private long access_expires;

  @Value("${jwt.auth.refreshexpires}")
  private long refresh_expires;

  @Override
  public boolean isValidation(String token, boolean type, MemberDTO memberDTO) {
    try {
      Jws<Claims> claims =
          Jwts.parser()
              .setSigningKey(getByteArrayFromSecret(type ? accessSecret : refreshSecret))
              .parseClaimsJws(token);

      

      if (claims.getBody().getExpiration().compareTo(new Date(System.currentTimeMillis())) > 0) {
        System.out.println("인증 실패, 토큰이 만료되었습니다");
        return false;
      }

      if (claims.getBody().getIssuer().compareTo(memberDTO.getEmail()) == 0) {
        System.out.println("인증 실패, 이용자가 정확하지 않습니다");
        return false;
      }

      return true;
    } catch (UnsupportedEncodingException | ExpiredJwtException e) {
      e.printStackTrace();
      System.out.println("인증 실패, 토큰이 만료되었습니다");
    } catch (SignatureException e) {
      e.printStackTrace();
      //  TODO : change to the logging system
      System.out.println("인증 실패, 키가 다릅니다");
    }
    return false;
  }

  @Override
  public String getAccessToken(MemberDTO memberDTO) throws UnsupportedEncodingException {
    return Jwts.builder()
        .setIssuer(memberDTO.getEmail())
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + access_expires))
        .claim("user", memberDTO.getName())
        .signWith(SignatureAlgorithm.ES256, getByteArrayFromSecret(accessSecret))
        .compact();
  }

  @Override
  public String getRefreshToken(MemberDTO memberDTO) throws UnsupportedEncodingException {
    return Jwts.builder()
        .setIssuer(memberDTO.getEmail())
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + refresh_expires))
        .claim("user", memberDTO.getName())
        .signWith(SignatureAlgorithm.ES256, getByteArrayFromSecret(refreshSecret))
        .compact();
  }

  private byte[] getByteArrayFromSecret(String secret) throws UnsupportedEncodingException {
    return secret.getBytes(StandardCharsets.UTF_8);
  }
}
