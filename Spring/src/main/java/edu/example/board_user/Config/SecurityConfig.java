package edu.example.board_user.Config;

import edu.example.board_user.Web.Service.MemberService;
import edu.example.board_user.Web.VO.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {


  private final MemberService service;

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(service).passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // @formatter:off
    http
        .authorizeRequests()
            .antMatchers("/","/success","/denied").permitAll()
            .antMatchers("/api/index/hello").permitAll()
            .antMatchers("/api/index/admin").hasAuthority(Role.ADMIN.name())
            .antMatchers("/api/index/user").hasAnyAuthority(Role.USER.name(), Role.MANAGER.name(), Role.ADMIN.name())
            .anyRequest().authenticated()
        .and()
          .formLogin()
            .loginPage("/login").permitAll()
            .successForwardUrl("/success")
            .defaultSuccessUrl("/success", true)
        .and()
          .logout()
            .permitAll()
        .and()
          .httpBasic()
        .and()
          .csrf().disable();
    // @formatter:on
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
