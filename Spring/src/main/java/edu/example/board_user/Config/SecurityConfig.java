package edu.example.board_user.Config;

import edu.example.board_user.Web.Service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private MemberService service;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(service).passwordEncoder(bCryptPasswordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .cors().disable()
        .formLogin().disable()
        .csrf().disable()
        .httpBasic().disable()
        .authorizeRequests()
        .antMatchers("/api/**", "/actuator/**", "/web-resources/**").permitAll()
        //        .mvcMatchers(HttpMethod.POST).permitAll()
        //        .antMatchers().hasRole(Role.ADMIN.name())
        //        .antMatchers().hasRole(Role.MANAGER.name())
        //        .antMatchers().hasRole(Role.USER.name())
        .anyRequest().authenticated()
        .and()
        .logout().disable();
    //        .logoutUrl("http://localhost:3000/logout");
  }

  @Bean
  public PasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
