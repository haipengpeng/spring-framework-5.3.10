package com.zhouyu.service;

import org.springframework.stereotype.Component;

@Component
public class User {
	private Long id;
	private String username;
	private String email;
	private Integer age;

	// 构造方法、getter、setter等
	public User() {}

	public User(Long id, String username) {
		this.id = id;
		this.username = username;
	}

	// getter和setter方法...
}

