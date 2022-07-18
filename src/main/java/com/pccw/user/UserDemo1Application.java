package com.pccw.user;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;


@SpringBootApplication(scanBasePackages = {"com.pccw.user"}, exclude = { DataSourceTransactionManagerAutoConfiguration.class, DruidDataSourceAutoConfigure.class , HibernateJpaAutoConfiguration.class})

@MapperScan("com.pccw.user.dao")
public class UserDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(UserDemo1Application.class, args);
	}

}
