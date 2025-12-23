package com.zhouyu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@ComponentScan("com.zhouyu")
@EnableScheduling
@PropertySource("classpath:spring.properties")
@EnableTransactionManagement
@Configuration // --事务  dataSource 不同对象 执行sql新建链接，没有用事务管理器的链接  代理模式，代理对象
//@EnableAspectJAutoProxy
public class AppConfig1 {

//	// @Bean会覆盖Component
//	@Bean
//	public OrderService orderService1(){
//		return new OrderService();
//	}
//	@Bean
//	public OrderService orderService2(){
//		return new OrderService();
//	}

//dataSource
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
// dataSource
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3308/testdb?characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true");

		dataSource.setUsername("root");
		dataSource.setPassword("root123");


//		dataSource.setUsername("haipeng");
//		dataSource.setPassword("haipengpeng");
		return dataSource;
	}


	//
//	@Bean
//	public SqlSessionFactory sqlSessionFactory() throws Exception {
//		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
//		sessionFactoryBean.setDataSource(dataSource());
//		return sessionFactoryBean.getObject();
//	}
//
//	@Bean
//	public SqlSessionTemplate sqlSession() throws Exception {
//		return new SqlSessionTemplate(sqlSessionFactory());
//	}

}

