package com.xushu.vip.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;


@Component
public class XushuService  {

}

//public class XushuService implements InstantiationAwareBeanPostProcessor {
//
//@Component
//public class XushuService implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware {
//	@Autowired
//	private UserService userService;
//
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		// todo 初始化
//	}
//
//	@Override
//	public void destroy() throws Exception {
//		// todo 销毁
//	}
//
//	@Override
//	public void setBeanName(String name) {
//
//	}
//
//	@Override
//	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//
//	}
//}
