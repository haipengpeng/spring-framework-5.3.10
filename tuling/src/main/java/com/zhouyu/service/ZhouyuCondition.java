package com.zhouyu.service;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ZhouyuCondition implements Condition {
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		try{
			context.getClassLoader().loadClass("com.zhouyu.service.User");

			return true;
		}catch (ClassNotFoundException e){
			return false;

		}
	}
}
