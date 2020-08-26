package com.example.board.Config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/css/**", "/script/**", "image/**", "lib/**", "/fonts/**");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
//        admin경로에 대해서는 ADMIN 권한을 가진 녀석만
        .antMatchers("/admin/**")
        .hasRole("ADMIN")
//        그외 모든 경로에 대해서는 모두 허용
        .antMatchers("/**")
        .permitAll();
  }

  // UserDetailsService를 이용해 인증을 해준다
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    super.configure(auth);
  }
}
