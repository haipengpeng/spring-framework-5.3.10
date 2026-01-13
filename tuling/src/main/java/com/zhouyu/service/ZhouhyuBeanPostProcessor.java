package com.zhouyu.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

@Component
public class ZhouhyuBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
//public class ZhouhyuBeanPostProcessor implements MergedBeanDefinitionPostProcessor {
//public class ZhouhyuBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
//public class ZhouhyuBeanPostProcessor implements BeanPostProcessor {


//	@Override
//	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//		System.out.println("实例化之前");
//		if (beanName.equals("zhouhyuService")){
//			Object instance = beanClass.getConstructor().newInstance();
//			return instance;
//		}
//		return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
//	}
//
//	@Override
//	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
//		System.out.println("实例化之后");
//		return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
//	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("zhouhyuService")){
			System.out.println("zhouhyuService初始化之前");
		}
		System.out.println("初始化之前");
		return bean;
//		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("初始化之后");
		return bean;
//		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
	}

	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
	}

	@Override
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
		// 处理@Autowired @Resource @Value
		return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
	}

	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
		return InstantiationAwareBeanPostProcessor.super.postProcessPropertyValues(pvs, pds, bean, beanName);
	}

//	@Override
//	public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
//		if (beanName.equals("userService")){
//			// 实例化之后属性赋值之前
//			beanDefinition.setInitMethodName("a");
//		}
//	}
//
//	@Override
//	public void resetBeanDefinition(String beanName) {
//		MergedBeanDefinitionPostProcessor.super.resetBeanDefinition(beanName);
//	}
}
