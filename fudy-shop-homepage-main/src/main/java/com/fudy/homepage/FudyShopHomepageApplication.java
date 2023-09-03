package com.fudy.homepage;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication(scanBasePackages = {"com.fudy.homepage"})
@MapperScan("com.fudy.homepage.infrastructure.mybatis.mapper")
public class FudyShopHomepageApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FudyShopHomepageApplication.class, args);
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		log.info("thread classloader: {}", contextClassLoader);
		log.info("current classloader:{}", FudyShopHomepageApplication.class.getClassLoader());
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			log.info("====> found bean, name: {}", name);
		}
	}

}
