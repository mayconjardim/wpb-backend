package com.wbpbackend.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.wbpbackend.api.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {

	 @Autowired
	 private DBService dbService;

	 @Value("${spring.jpa.hibernate.ddl-auto}")
	 private String ddl;
	 
	 @Bean
	 public boolean initDB() {
		  
		 if (ddl.equals("create")) {
			 this.dbService.runDB();
		 }
		
		return false;
	 }
	
	
}
