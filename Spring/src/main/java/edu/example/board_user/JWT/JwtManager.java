package edu.example.board_user.JWT;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import edu.example.board_user.Web.VO.Member;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

public class JwtManager {

  private final long expires = 10 * 60 * 1000;

  @Value("${oauth.jwt.secret}")
  private String secret;

  private final Algorithm algorithm = Algorithm.HMAC256(secret);

  public String create(Member member) throws JWTCreationException {

    return JWT.create()
              .withExpiresAt(new Date(System.currentTimeMillis() + expires))  // 현재시간 (current~~) + 만료할 시간
              .withIssuer(member.getEmail())
              .sign(algorithm);
  }

  public boolean verify(String token) throws JWTVerificationException {
    JWTVerifier verifier = JWT.require(algorithm)
                              .withIssuer("me")
                              .acceptExpiresAt(expires)
                              .build();
    DecodedJWT decodedJWT = verifier.verify(token);

    return true;
  }

  public String decode(String token) {
    return JWT.decode(token).toString();
  }

}
