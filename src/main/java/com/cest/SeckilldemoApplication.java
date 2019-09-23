package com.cest;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cest.dao")
@Slf4j
public class SeckilldemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(SeckilldemoApplication.class, args);

		log.info("http://localhost:8090");
	}

}
