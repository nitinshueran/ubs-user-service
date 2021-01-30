package com.ubs.assesment.nitin.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.ubs.assesment.nitin")
@EnableJpaRepositories(basePackages = { "com.ubs.assesment.nitin.repository" })
@EntityScan(basePackages = { "com.ubs.assesment.nitin.entity" })
public class UbsUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UbsUserServiceApplication.class, args);
	}

}
