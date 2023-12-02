package com.fudy.homepage;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication(scanBasePackages = {"com.fudy.homepage"})
@MapperScan("com.fudy.homepage.infrastructure.mybatis.mapper")
public class FudyShopHomepageApplication {

	public static void main(String[] args) {
		SpringApplication.run(FudyShopHomepageApplication.class, args);
	}

}
