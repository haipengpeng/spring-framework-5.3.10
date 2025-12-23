package com.zhouyu.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component // 切面也是一种特殊的bean
public class ZhouyuAspect {

	@Pointcut("execution(public void com.zhouyu.service.UserService.test())")
	public void a(){

	}

	@Before("a()")
	public void zhouyuBefore(JoinPoint joinPoint) {
//		joinPoint.getTarget()
		System.out.println("zhouyuBefore");
	}


}
