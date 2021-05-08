package edu.example.board_user.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GlobalConfig implements WebMvcConfigurer {
  @Override
  public void addCorsMappings(CorsRegistry registry) {
// cors 적용
    WebMvcConfigurer.super.addCorsMappings(registry);
    registry.addMapping("/**") //  모든 경로에 대하여
        .allowedOriginPatterns("*")  // 모든 오리진 허용
        .maxAge(3600);
  }
}
