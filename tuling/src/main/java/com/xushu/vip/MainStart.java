package com.xushu.vip;



import com.xushu.vip.service.UserService;
import com.xushu.vip.service.XushuService;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * Created by smlz on 2019/7/7.
 */
@Configuration
@ComponentScan
public class MainStart {

	public static void main(String[] args) {
		System.out.println(111);
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainStart.class);
//		XushuService xushuService = (XushuService) ctx.getBean("xushuService");
//		System.out.println(xushuService);
//###############
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MainStart.class);

		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
		AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(beanFactory);
		reader.register(MainStart.class);

		AnnotatedGenericBeanDefinition beanDefinition =
				(AnnotatedGenericBeanDefinition) beanFactory.getBeanDefinition("mainStart");

		AnnotationMetadata metadata = beanDefinition.getMetadata();
		System.out.println(metadata.getClassName());
		if (metadata.hasAnnotation(ComponentScan.class.getName())){
			Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ComponentScan.class.getName());
			// Utils if basepackages == '' 当前配置类的包当作扫描包
		}
		ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(beanFactory);
		scanner.scan("com.xushu.vip");
		System.out.println(beanFactory.getBean("xushuService"));
		System.out.println(beanFactory.getBean("xushuService"));

		// vm option
		System.out.println(context.getEnvironment().getProperty("hp"));
		System.out.println(beanFactory.getBean("userService"));
		System.out.println(beanFactory.getBean("&userService"));



//		beanFactory.getBean("userService");
//		System.out.println(context.getBean("userService"));
// ##############################
//		AnnotationConfigApplicationContext context =
//				new AnnotationConfigApplicationContext();
//
//		// 1️⃣ 用 AnnotatedGenericBeanDefinition 注册 Bean
//		AnnotatedGenericBeanDefinition abd =
//				new AnnotatedGenericBeanDefinition(UserService.class);
//		context.registerBeanDefinition("userService", abd);
//
//		// 2️⃣ refresh
//		context.refresh();
//
//		// 3️⃣ 读取 BeanDefinition（这是 OK 的）
//		AnnotatedGenericBeanDefinition bd =
//				(AnnotatedGenericBeanDefinition)
//						context.getBeanDefinition("userService");
//
//		AnnotationMetadata metadata = bd.getMetadata();
//		System.out.println(metadata.getClassName());
//
//		// 4️⃣ scanner 必须使用 context（Registry）
//		ClassPathBeanDefinitionScanner scanner =
//				new ClassPathBeanDefinitionScanner(context);
//		scanner.scan("com.xushu.vip");
//
//		// 5️⃣ getBean 只能从 context
//		System.out.println(context.getBean("userService"));

//// #####################
//		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//		AnnotationConfigApplicationContext reader =
//				new AnnotationConfigApplicationContext();
//
//		reader.register(MainStart.class);
//		reader.refresh(); // ⭐⭐⭐ 关键
////
////		AnnotatedGenericBeanDefinition beanDefinition =
////				(AnnotatedGenericBeanDefinition) reader.getBeanDefinition("userService");
////		BeanDefinition beanDefinition =
////				reader.getBeanDefinition("userService");
//
//		AnnotatedBeanDefinition beanDefinition =
//				(AnnotatedBeanDefinition) reader.getBeanDefinition("userService");
//
//
//		System.out.println(22222);
//
//		AnnotationMetadata metadata = beanDefinition.getMetadata();
//		System.out.println(metadata.getClassName());
	}
}
