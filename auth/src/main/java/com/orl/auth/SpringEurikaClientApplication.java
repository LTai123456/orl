package com.orl.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableAutoConfiguration
@EnableConfigurationProperties
@MapperScan("com.orl.auth.mapper")
public class SpringEurikaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurikaClientApplication.class, args);
	}
}
