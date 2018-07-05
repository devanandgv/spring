package com.test.spring.web.emzbankcustomer.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomerControllerAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	@Before("execution(public * getCustomer(*))")
	public void loggingAdvice() {
		logger.info("in advice");
	}
}

