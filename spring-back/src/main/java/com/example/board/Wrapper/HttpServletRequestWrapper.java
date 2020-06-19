package com.example.board.WrapperTest;

import java.io.IOException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

/**
 * Warpper class of ServletRequest 인증을 위해 intercpetor에서 josn타입의 데이터를 읽어야 했다. Post로 보낸 요청의 body에서
 * 데이터를 꺼낼 때, inputstream을 사용해야 하는데 interceptor에서 스트림을 이용해 데이터를 읽으면 더이상 스트림을 이용한 데이터 추출이 불가능해
 * controller에서 읽으려 할 때, exception이 발생하였다. 이를 막기 위해 ServletRequest의 warpper클래스를 만들고 wapper클래스에서
 * inputstream을 읽어들이는 것으로 해결할 수 있다.
 */
public class HttpServletRequestWrapper extends javax.servlet.http.HttpServletRequestWrapper {

  private final HttpServletRequest request;

  private final ServletInputStream inputStream;

  /**
   * Constructs a request object wrapping the given request.
   *
   * @param request The request to wrap
   * @throws IllegalArgumentException if the request is null
   */
  public HttpServletRequestWrapper(HttpServletRequest request) throws IOException {
    super(request);
    this.request = request;
    this.inputStream = request.getInputStream();
  }

  @Override
  public String getParameter(String name) {
    return this.request.getParameter(name);
  }

  @Override
  public ServletInputStream getInputStream() throws IOException {
    return this.inputStream;
  }

  @Override
  public String getHeader(String name) {
    return this.request.getHeader(name);
  }
}
