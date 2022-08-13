package com.example.demo;

import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //allows classes to serve restful endpoints
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext =
				SpringApplication.run(DemoApplication.class, args);

		//printing all beans (java object created by spring when app starts) present
//		for(String name : applicationContext.getBeanDefinitionNames()) {
//			System.out.println(name);
//		}
	}

}
