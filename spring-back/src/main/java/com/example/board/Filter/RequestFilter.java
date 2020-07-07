package com.example.board.Filter;

import com.example.board.Wrapper.RequestWrapper;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "/*")
public class RequestFilter implements Filter {

  //  filter로 요청을 받은 후 매퍼클래스를 이용해 실제 로직으로 던져준다

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    chain.doFilter(new RequestWrapper((HttpServletRequest) request), response);
  }
}
