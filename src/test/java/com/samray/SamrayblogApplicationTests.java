package com.samray;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootApplication
@EnableTransactionManagement //开启注解事务管理，等同于xml配置文件中的<tx:annotation-driven/>
public class SamrayblogApplicationTests {

	@Test
	public void contextLoads() {
	}

}
