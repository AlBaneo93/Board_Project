package edu.example.board_user.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class GlobalConfig implements WebMvcConfigurer {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    WebMvcConfigurer.super.addInterceptors(registry);
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    WebMvcConfigurer.super.addResourceHandlers(registry);
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    WebMvcConfigurer.super.addCorsMappings(registry);
    registry.addMapping("/**")  // 모든 경로에 대하여
            .allowedOriginPatterns("*") // 모든 오리진 허용
            .maxAge(3600);
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("main");
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/hello").setViewName("hello");

  }

}
