package com.zhouyu;

import com.zhouyu.service.OrderService;
import com.zhouyu.service.User;
import com.zhouyu.service.UserService;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//bean创建生命周期
// UserService.class --->无参构造方法[先根据类型，后根据名字来推断构造方法]--->普通对象—->依赖注入（属性赋值）--•-＞
// 初始化前（a（）@PostConstruct）---＞初始化【doCreateBean、initializeBean】-⋯-＞初始化后【AOP判断】--》代理对象成为bean •-- > Bean

//1. 找出所有切面Bean
//2．遍历
//3．遍历方法
//4.方法===》USerSerivce 缓存 BeanDefinitionMap <UserSer.clsss, mehthd>


//cglib UserServiceProxy--•>代理对象-••>代理对象.target=普通对象
// class UserServiceProxy extends UserService


// 1. @Transa

// 2. 创建一个数据库连接conn（事务管理器 dataSource）
//3. conn.autocommit = true默认 改为false

public class Test {

	public static void main(String[] args) {

//		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//		System.out.println(applicationContext.getBean("orderService"));
//		System.out.println(applicationContext.getBean("orderService1"));
//		System.out.println(applicationContext.getBean("orderService2"));

		System.out.println(1111);




////xml
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		// XmlBeanDefinitionReader
//		UserService userService_xml = (UserService) context.getBean("userService");
//		userService_xml.test();
		// 创建一个Spring容器 // 非懒加载的单例Bean，
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		// 原型bean
		UserService userService = (UserService) applicationContext.getBean("userService");
		userService.test();
//		AnnotatedBeanDefinitionReader
//		Thread.currentThread().setContextClassLoader();
//		applicationContext.getBeanFactory().setBeanClassLoader();




//		// 等价于
//		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.register(AppConfig.class);
//		AnnotatedGenericBeanDefinition beanDefinition = (AnnotatedGenericBeanDefinition)context.getBeanDefinition("userService");
//		AnnotationMetadata metadata = beanDefinition.getMetadata();
//		if (metadata.hasAnnotation(ComponentScan.class.getName())){
//			Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ComponentScan.class.getName());
//			// basePackage ='' 当前类所在的包默认扫描包
//		}
//		ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(beanFactory);
//		scanner.scan("com.zhouyu");
//
//
//		System.out.println(beanFactory.getBean("userService"));
////		// 等价于
//		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.register(AppConfig1.class);

//		AnnotationConfigApplicationContext parent = new AnnotationConfigApplicationContext(AppConfig.class);
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.register(AppConfig.class);
//		context.setParent(parent);
//		context.refresh();
//		context.getBean("zhouyuFactoryBean");
//		context.getBean("&&&zhouyuFactoryBean");



////		扫描两次
//
//		context.refresh();

		System.out.println(111);
//		// 手动创建UserService实例（模拟Spring的bean创建过程）
//		UserService userService1 = new UserService();
//
//		// 依赖注入过程
//		for (Field field : userService1.getClass().getDeclaredFields()) {
//			if (field.isAnnotationPresent(Autowired.class)) {
//				field.setAccessible(true); // 允许访问private字段
//
//				try {
//					// 从Spring容器中获取对应类型的bean
//					Object dependencyBean = applicationContext.getBean(field.getType());
//
//					// 注入依赖
//					field.set(userService1, dependencyBean);
//					System.out.println("成功注入依赖: " + field.getName() + " = " + dependencyBean);
//
//				} catch (IllegalAccessException e) {
//					throw new RuntimeException("字段注入失败: " + field.getName(), e);
//				} catch (Exception e) {
//					System.out.println("无法注入字段 " + field.getName() + ": " + e.getMessage());
//				}
//			}
//		}
//
//		System.out.println(222);
//
//		// 执行@PostConstruct方法
//		for (Method method : userService1.getClass().getDeclaredMethods()) {
//			if (method.isAnnotationPresent(PostConstruct.class)) {
//				method.setAccessible(true);
//				try {
//					method.invoke(userService1);
//				} catch (Exception e) {
//					throw new RuntimeException("@PostConstruct方法执行失败", e);
//				}
//			}
//		}
//		System.out.println(333);
//
//		// 执行InitializingBean接口方法（如果实现了）
//		if (userService1 instanceof InitializingBean) {
//			try {
//				((InitializingBean) userService1).afterPropertiesSet();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//		System.out.println(444);
//
//
//		ProxyFactory proxyFactory = new ProxyFactory();
//		proxyFactory.setTarget(userService);
//		proxyFactory.addAdvice(new MethodInterceptor() {
//			@Nullable
//			@Override
//			public Object invoke(@NotNull MethodInvocation invocation) throws Throwable {
//				System.out.println("切面逻辑 before...");
//				Object result = invocation.proceed();
////				Object result = invocation.getMethod().invoke(invocation.getThis(), invocation.getArguments());
//				System.out.println("切面逻辑 after...");
//				return result;
//			}
//		});
//		UserService userService2  = (UserService) proxyFactory.getProxy();
//		userService2.test();

	}
}







