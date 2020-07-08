package com.example.board.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLogger {
  private static final String TAG = ServiceLogger.class.getSimpleName();
  private static final Logger logger = LoggerFactory.getLogger(ServiceLogger.class);

  // service 패키지의 모든 클래스의 모든 메소드의 모든 함수를
  // 실행하기전 정의된 함수 실행
  @Before(value = "execution(* com.example.board.Service.*.*(..))")
  public void beforeEnterLogger(JoinPoint joinPoint) {
    //    logger.debug(TAG + "/before");
    //    logger.info("Target : " + joinPoint.getTarget().getClass().getName());
    //    logger.info("DeclaringType : " + joinPoint.getSignature().getName()); // 함수의 이름을 가져옴

    // 요청한 메서드와 클래스를 로깅
    logger.debug(
        "call : "
            + joinPoint.getTarget().getClass().getName()
            + "/"
            + joinPoint.getSignature().getName());
  }

  // service 패키지의 모든 클래스의 모든 메소드의 모든 함수를
  // 실행하고 나서 정의된 함수 실행
  @After("execution(* com.example.board.Service.*.*(..))")
  public void afterOutLogger() {
    logger.info("Service aop test : AFTER");
  }

  @AfterThrowing("execution(* com.example.board.Service.*.*(..)))")
  public void afterThrow(JoinPoint joinPoint) {
    logger.info("after throwing : before error print");

    //    에러를 나타낼 수 있을까?
    //    에러를 찾지는 못한다. 그러면 이건 에러가 발생하는 controller 부분에서 로그처리를 해주자
    logger.error(
        joinPoint.getThis().getClass().getPackageName() + joinPoint.getSignature().getName());
    logger.info("after throwing : after error print");
  }

  @AfterReturning("execution(* com.example.board.Service.*.*(..)))")
  public void afterReturn(JoinPoint joinPoint) {
    logger.info("After Return aop");
    for (Object obj : joinPoint.getArgs()) {
      System.out.println(obj.toString());
    }
  }
}
