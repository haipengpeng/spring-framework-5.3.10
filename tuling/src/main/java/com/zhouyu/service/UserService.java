package com.zhouyu.service;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;


@Component
@Lazy
@Conditional(ZhouyuCondition.class) // 条条件注解，符合条件才是bean



//public abstract class UserService  {
public class UserService  {

//	class Member {
//
//	}
//public class UserService  implements  InitializingBean {

	private  OrderService orderService;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private UserServiceBase userServiceBase;

	@Autowired
	private UserService userService;

	@Transactional
	public void test(){
		System.out.println(1111);
//		jdbcTemplate.execute("insert t1 values(1,1);");
//		throw new NullPointerException("null");
//		test2();
//		userServiceBase.test2();
//		userService.test2();
	}
//	@Lookup("user") // 找一个user不同的对象
//	public void a(){
//		System.out.println("a");
//	}


	@Transactional(propagation = Propagation.NEVER)
	// 非事务的方式运行：已经有一个事务了，never抛异常 事务失效：
	// UserService的代理对象去调用，就有用
	public void test2(){

	}

//	public UserService() {
//		// spring 用1
//		System.out.println(1);
//	}

	@Autowired
	// 两个有参数，取1个
	public UserService(OrderService orderService) {
//	public UserService(OrderService orderService123) {
		this.orderService = orderService;
		System.out.println(2);
	}
	public UserService(OrderService orderService,OrderService orderService2) {
		this.orderService = orderService;
		System.out.println(3);
	}
//
//	@Autowired
//	public OrderService orderService;
//
//	@Autowired
//	public User admin;
//
//	public void test(){
//		System.out.printf("111");
//		System.out.println(orderService);
//	}
//
//	@PostConstruct
//	public void a (){
//		System.out.println("UserService:::a");
//	}
//
////public class UserService  implements  InitializingBean {
//
	// 属性设置后
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		System.out.println("UserService:::afterPropertiesSet");
//	}
}
