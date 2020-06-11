package com.example.board.Config;

import com.example.board.Interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
public class GlobalConfig implements WebMvcConfigurer {

  @Autowired private LoginInterceptor loginInterceptor;

  @Value("${interceptor.path.include}")
  private String[] addPathPatterns;

  @Value("${interceptor.path.exclude}")
  private String[] excludePathPatterns;

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**").allowedOrigins("*").maxAge(3600);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(loginInterceptor).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
  }
}
