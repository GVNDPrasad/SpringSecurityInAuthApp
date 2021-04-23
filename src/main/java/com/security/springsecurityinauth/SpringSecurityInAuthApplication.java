package com.security.springsecurityinauth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// Spring Security application for In-memory Authentication
@SpringBootApplication
public class SpringSecurityInAuthApplication {
    
	private static final Logger log = LoggerFactory.getLogger(SpringSecurityInAuthApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityInAuthApplication.class, args);
		log.info("SpringSecurityInAuthApplication :: main()");
	}

}
