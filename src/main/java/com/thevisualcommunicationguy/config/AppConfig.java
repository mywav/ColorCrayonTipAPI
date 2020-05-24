package com.thevisualcommunicationguy.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class AppConfig implements WebApplicationInitializer {
//	@Bean(name = "entityManagerFactory")
//	public LocalEntityManagerFactoryBean entityManagerFactory(){
//	     LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
//	     factoryBean.setPersistenceUnitName("quiz-persistence-unit");
//	     return factoryBean;
//	}

	@Bean
	public DataSource dataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.postgresql.Driver");
		dataSourceBuilder.url(
				"postgres://mzyxfkgazradhd:da8088a6cf4657d729b56fddadccfcf44b38f9a0a826a64396ccf66495c17ec2@ec2-52-44-166-58.compute-1.amazonaws.com:5432/debsupspc92meh");
		dataSourceBuilder.username("mzyxfkgazradhd");
		dataSourceBuilder.password("da8088a6cf4657d729b56fddadccfcf44b38f9a0a826a64396ccf66495c17ec2");
		return dataSourceBuilder.build();
	}

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		XmlWebApplicationContext context = new XmlWebApplicationContext();
		context.setConfigLocation("/WEB-INF/spring/dispatcher-config.xml");

		ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(context));

		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}
}
