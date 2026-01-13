package com.xushu.vip.service;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

@Component
@Lazy
public class UserService implements FactoryBean {
//	@Autowired
//	// 我希望当前的bean 在最后面 。注入

	public UserService(){

	}

	@Override
	public Object getObject() throws Exception {
//		Proxy.newProxyInstance(UserService)
//				// 动态代理对象、赋值
		return new XushuService();
	}

	@Override
	public Class<?> getObjectType() {
		return new XushuService().getClass();
	}

	@Override
	public boolean isSingleton() {
		return FactoryBean.super.isSingleton();
	}
}
