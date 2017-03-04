package com.mathologic.projects;

import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

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



