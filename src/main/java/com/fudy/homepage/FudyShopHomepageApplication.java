package com.fudy.homepage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fudy.homepage.infrastructure.mybatis.mapper")
public class FudyShopHomepageApplication {

	public static void main(String[] args) {
		SpringApplication.run(FudyShopHomepageApplication.class, args);
	}

}
