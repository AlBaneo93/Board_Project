package edu.example.board_user.Config;

import edu.example.board_user.Web.Service.MemberService;
import edu.example.board_user.Web.VO.Role;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
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
@AllArgsConstructor
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private MemberService service;

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    log.info("auth configure access");
    auth.userDetailsService(service).passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    //    http.logout().invalidateHttpSession(true).deleteCookies("JSESSIONID").and()
    //        .formLogin().loginPage("/login").usernameParameter("email").passwordParameter("pass").permitAll().and()
    //        .cors().disable()
    //        .csrf().disable()
    //        .httpBasic().disable();

    //    세션 설정, 세션 생성 정책은 stateless로
    //    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    //    http.authorizeRequests()
    //        .antMatchers("/api/**", "/actuator/**", "/web-resources/**").permitAll();

    http.authorizeRequests()
        .antMatchers("/login", "/hello", "/home", "/api/member").permitAll()
        .antMatchers("/api/index/admin").hasRole(Role.ADMIN.name())
        .antMatchers("/api/index/user").hasRole(Role.USER.name())
        .antMatchers("/api/index/manager").hasRole(Role.MANAGER.name())
        .antMatchers("/api/admin/**").hasRole(Role.ADMIN.name())
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .usernameParameter("email")
        .passwordParameter("password")
        .defaultSuccessUrl("/");

    //    http
    //        .antMatcher("/api/member/**")
    //        .authorizeRequests()
    //        .antMatchers("/api/member/admin").hasRole(Role.ADMIN.name())
    //        .antMatchers(HttpMethod.POST).permitAll() // 모든 접근 허용
    //        //        .anyRequest().hasRole(Role.USER.name())
    //        // 가입외 모든 경로는 해당 권한중 하나만 접근 가능
    //        //        .anyRequest().hasAnyRole(Role.USER.name(), Role.ADMIN.name(), Role.MANAGER.name());
    //        .anyRequest().permitAll();

  }

  @Bean
  public DaoAuthenticationProvider customAuthenticationProvider() {
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setPasswordEncoder(passwordEncoder());
    authenticationProvider.setUserDetailsService(service);
    return authenticationProvider;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
