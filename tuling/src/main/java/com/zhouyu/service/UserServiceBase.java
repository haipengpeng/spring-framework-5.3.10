package com.zhouyu.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Component
public class UserServiceBase {

	@Transactional(propagation = Propagation.NEVER)
	// 非事务的方式运行：已经有一个事务了，never抛异常 事务失效：代理对象去调用，就有用
	public void test2(){

	}
}
