package com.example.board.Config;

import com.example.board.Interceptor.LoginInterceptor;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@AllArgsConstructor
public class GlobalConfig implements WebMvcConfigurer {

  private final LoginInterceptor loginInterceptor;

  @Value("${interceptor.path.include}")
  private String[] addPathPatterns;

  @Value("${interceptor.path.exclude}")
  private String[] excludePathPatterns;

  public GlobalConfig(LoginInterceptor loginInterceptor) {
    this.loginInterceptor = loginInterceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry
        .addInterceptor(loginInterceptor)
        .addPathPatterns(addPathPatterns)
        .excludePathPatterns(excludePathPatterns);
  }
}
