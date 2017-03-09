package com.mathologic.projects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = { "com.mathologic.projects",
		"com.mathologic.projects.controllers","com.mathologic.projects.repository" ,"com.mathologic.projects.models","com.mathologic.projects.utils","com.mathologic.projects.service"})
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages={"com.mathologic.projects.repository"})
@SpringBootApplication
public class Crewlink01Application {

	public static void main(String[] args) {
		SpringApplication.run(Crewlink01Application.class, args);
	}
}

 class WebInitializer extends SpringBootServletInitializer {   
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Crewlink01Application.class);
    }    
}

