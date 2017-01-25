package com.samray;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement //开启注解事务管理，等同于xml配置文件中的<tx:annotation-driven/>
public class SamrayBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamrayBlogApplication.class, args);
	}
}
