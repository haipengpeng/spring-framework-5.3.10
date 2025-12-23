package com.zhouyu.service;

import org.springframework.beans.factory.SmartFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class ZhouyuFactoryBean implements SmartFactoryBean {
	@Override
	public Object getObject() throws Exception {
		return new User();
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}

	@Override
	public boolean isSingleton() {
		return SmartFactoryBean.super.isSingleton();
	}

	@Override
	public boolean isPrototype() {
		return SmartFactoryBean.super.isPrototype();
	}

	@Override
	public boolean isEagerInit() {
//		return SmartFactoryBean.super.isEagerInit();
		return true;
		// 启动时候会getObject()生成对象
	}
}
