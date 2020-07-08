package com.example.board.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerLogger {
  private static final Logger logger = LoggerFactory.getLogger(ControllerLogger.class);

  //  모든 컨트롤러에서 발생하는 에러를 로깅하기 위한 메소드
  @AfterThrowing("execution (* com.example.board.Controller.*.*(..))")
  public void controllerErrorLoger(JoinPoint joinPoint) {
    logger.error(
        joinPoint.getThis().getClass().getPackageName() + "." + joinPoint.getSignature().getName());
  }
}
