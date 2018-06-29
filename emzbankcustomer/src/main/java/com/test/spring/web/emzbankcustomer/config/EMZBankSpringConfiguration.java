package com.test.spring.web.emzbankcustomer.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.test.spring.web.emzbankcustomer.aspect.CustomerControllerAspect;
import com.test.spring.web.emzbankcustomer.dao.CustomerDAO;
import com.test.spring.web.emzbankcustomer.dao.CustomerDAOImpl;
import com.test.spring.web.emzbankcustomer.model.Customer;
import com.test.spring.web.emzbankcustomer.service.CustomerService;
import com.test.spring.web.emzbankcustomer.service.CustomerServiceImpl;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.test.spring.web.emzbankcustomer")
public class EMZBankSpringConfiguration {

	@Bean
	public CustomerService customerService() {

		return new CustomerServiceImpl();
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setOrder(0);
		return viewResolver;
	}

	public DataSource dataSource() {

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/emz");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {

		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setHibernateProperties(hibernateProperties());
		sessionFactory.setAnnotatedClasses(Customer.class);
		sessionFactory.setAnnotatedPackages("com.test.spring.web.emzbankcustomer.model");
		return sessionFactory;
	}

	private final Properties hibernateProperties() {

		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		return hibernateProperties;
	}
	@Bean
	public CustomerDAO customerDAO() {

		return new CustomerDAOImpl();
	}
	
	@Bean
	public CustomerControllerAspect customerControllerAspect() {

		return new CustomerControllerAspect();
	}
}
