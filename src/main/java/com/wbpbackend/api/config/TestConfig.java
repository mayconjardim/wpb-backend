package com.wbpbackend.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.wbpbackend.api.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	 @Autowired
	 private DBService dbService;
	 
	 @Bean
	 public void initDB() {
		 this.dbService.runDB();
	 }
	
	
}
