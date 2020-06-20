package com.example.board.Wrapper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Warpper class of ServletRequest 인증을 위해 intercpetor에서 josn타입의 데이터를 읽어야 했다. Post로 보낸 요청의 body에서
 * 데이터를 꺼낼 때, inputstream을 사용해야 하는데 interceptor에서 스트림을 이용해 데이터를 읽으면 더이상 스트림을 이용한 데이터 추출이 불가능해
 * controller에서 읽으려 할 때, exception이 발생하였다. 이를 막기 위해 ServletRequest의 warpper클래스를 만들고 wapper클래스에서
 * inputstream을 읽어들이는 것으로 해결할 수 있다.
 */
public class RequestWrapper extends HttpServletRequestWrapper {

  private Charset encoding;
  private byte[] rawData;

  /**
   * Constructs a request object wrapping the given request.
   *
   * @param request The request to wrap
   * @throws IllegalArgumentException if the request is null
   */
  public RequestWrapper(HttpServletRequest request) throws IOException {
    super(request);
    String characterEncoding = request.getCharacterEncoding();

    if (StringUtils.isBlank(characterEncoding)) {
      characterEncoding = StandardCharsets.UTF_8.name();
    }
    this.encoding = Charset.forName(characterEncoding);

    try {
      InputStream inputStream = request.getInputStream();
      this.rawData = IOUtils.toByteArray(inputStream);
    } catch (Exception e) {
      throw e;
    }
  }

  @Override
  public ServletInputStream getInputStream() throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.rawData);
    ServletInputStream servletInputStream =
        new ServletInputStream() {
          @Override
          public boolean isFinished() {
            return false;
          }

          @Override
          public boolean isReady() {
            return false;
          }

          @Override
          public void setReadListener(ReadListener listener) {}

          @Override
          public int read() throws IOException {
            return byteArrayInputStream.read();
          }
        };
    return servletInputStream;
  }

  @Override
  public ServletRequest getRequest() {
    return super.getRequest();
  }

  @Override
  public BufferedReader getReader() throws IOException {
    return new BufferedReader(new InputStreamReader(this.getInputStream(), this.encoding));
  }
}
