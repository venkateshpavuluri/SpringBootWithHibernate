package com.boot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.test.context.ActiveProfiles;

@SpringBootApplication
@ComponentScan("com")

public class SpringBootWebApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootWebApplication.class);
	}

	public static void main(String[] args) throws Exception {
		/*SpringApplication application=new SpringApplication(SpringBootWebApplication.class);
		ConfigurableEnvironment environment=new StandardEnvironment();
		environment.setActiveProfiles("dev");
		application.setEnvironment(environment);*/
		SpringApplication.run(SpringBootWebApplication.class,args);
	}

}