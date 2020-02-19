package com.thevisualcommunicationguy.config;


import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class AppConfig {
//	@Bean(name = "entityManagerFactory")
//	public LocalEntityManagerFactoryBean entityManagerFactory(){
//	     LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
//	     factoryBean.setPersistenceUnitName("quiz-persistence-unit");
//	     return factoryBean;
//	}
	
	@Bean
	public DataSource dataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.sqlite.JDBC");
		dataSourceBuilder.url("jdbc:sqlite:colorcrayontip.db");
		return dataSourceBuilder.build();
	}
}
