package com.zhouyu;

import com.zhouyu.service.User;
import com.zhouyu.service.UserService;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		// 生成一个BeanDefinition对象，并设置beanClass为User.class，并注册到ApplicationContext中
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		beanDefinition.setBeanClass(User.class);
		context.registerBeanDefinition("user", beanDefinition);
		System.out.println(context.getBean("user"));
	}
}
