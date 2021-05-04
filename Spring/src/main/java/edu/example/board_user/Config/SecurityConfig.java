package edu.example.board_user.Config;

import edu.example.board_user.Auth.CustomAuthManager;
import edu.example.board_user.Web.Service.MemberService;
import edu.example.board_user.Web.VO.Authority;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Slf4j
@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final PasswordEncoder passwordEncoder;

  private final MemberService service;

  //  private final RestAuthEntiryPoint restAuthEntiryPoint;

  //  private final AuthenticationProvider myCustomProvider;

  //  private final CustomAuthFailureHandler failureHandler;
  //
  //  private final CustomAuthSuccessHandler successHandler;

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //          Auth provider를 따로 설정하면 이곳에~
    auth.userDetailsService(service).passwordEncoder(passwordEncoder);
    //      auth.authenticationProvider(myCustomProvider);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    // @formatter:off
    http
        .authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll() // preflight permitted
            .antMatchers("/","/success","/denied","/auth/login").permitAll()
            .antMatchers("/api/index/hello").permitAll()
            .antMatchers("/api/index/admin").hasAuthority(Authority.ADMIN.name())
            .antMatchers("/api/index/user").hasAnyAuthority(Authority.USER.name(), Authority.MANAGER.name(), Authority.ADMIN.name())
            .anyRequest().authenticated()
//        .and()
//          .exceptionHandling()
//          .authenticationEntryPoint(restAuthEntiryPoint)
//        .and()
          // 하단 커스텀 필터를 따름
//          .formLogin()
//            .loginProcessingUrl("/auth/login")
//            .successHandler(successHandler)
//            .failureHandler(failureHandler)
//            .permitAll()
        .and()
          .logout()
            .permitAll().invalidateHttpSession(true)
//        .and()
//          .httpBasic()
        .and()
          .csrf().disable()
          .cors().configurationSource(configurationSource());
//        .and()
//        // UsernamePasswordAuthenticationFilter앞에 customAuthenticationFilter를 추가한다
//        .addFilterBefore(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    // @formatter:on
  }


  //    @Bean
  //    public AuthenticationProvider authenticationProvider() {
  //      DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
  //      authenticationProvider.setUserDetailsService(service);
  //      authenticationProvider.setPasswordEncoder(passwordEncoder);
  //      return authenticationProvider;
  //    }


//  @Bean
//  public CustomAuthenticationFilter customAuthenticationFilter() {
//    // 이 경로로 들어오는 요청을 잡아서 Authentication 처리를 하겠다
//    CustomAuthenticationFilter filter = new CustomAuthenticationFilter("/auth/login");
//    filter.setAuthenticationManager(manager());
//    filter.setAuthenticationSuccessHandler(new CustomAuthSuccessHandler());
//    filter.setAuthenticationFailureHandler(new CustomAuthFailureHandler());
//    return filter;
//  }

  @Bean
  public CustomAuthManager manager() {
    return new CustomAuthManager(service);
  }

  @Bean
  public CorsConfigurationSource configurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.addAllowedMethod("*");
    configuration.addAllowedOrigin("*");
    configuration.addAllowedHeader("*");
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }

}
