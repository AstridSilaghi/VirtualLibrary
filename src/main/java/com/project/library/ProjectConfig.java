package com.project.library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan
public class ProjectConfig {

	@Bean
	public InternalResourceViewResolver internalRezolver()
	{
		InternalResourceViewResolver irv = new InternalResourceViewResolver();
		
		irv.setPrefix("WEB-INF/");
		irv.setSuffix(".jsp");
		
		return irv;
	}
}
