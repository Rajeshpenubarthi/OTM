package com.overtamilmatrinmony.core.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
// @PropertySource("classpath:db.properties,otp.properties")
@ComponentScan(basePackages =
	{ "com.overtamilmatrinmony.core.controller" })
public class WebConfig extends WebMvcConfigurerAdapter
	{

		@Bean
		public MessageSource messageSource()
			{
				ResourceBundleMessageSource source = new ResourceBundleMessageSource();
				source.setBasename("otp");
				return source;
			}

		/*
		 * @Bean public ModelMapper modelMapper() { return new ModelMapper(); }
		 */
	}
