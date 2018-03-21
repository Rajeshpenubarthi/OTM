package com.overtamilmatrinmony.core.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.hibernate.cfg.AvailableSettings.DIALECT;
import static org.hibernate.cfg.Environment.*;

@Configuration
@PropertySource("classpath:mailer.properties")
@EnableTransactionManagement
@ComponentScans(value =
	{ @ComponentScan("com.overtamilmatrinmony.core.mailer.dao"), @ComponentScan("com.overtamilmatrinmony.core.mailer.service") })
public class OTMMailerConfig
	{

		@Autowired
		private Environment env;

		
		@Bean
	    public JavaMailSender getMailSender(){
	        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	         
	        //Using gmail
	        mailSender.setHost(env.getProperty("domain"));
	        mailSender.setPort(Integer.parseInt(env.getProperty("post")));
	        mailSender.setUsername(env.getProperty("userId"));
	        mailSender.setPassword(env.getProperty("password"));
	         
	        Properties javaMailProperties = new Properties();
	        javaMailProperties.put("mail.smtp.starttls.enable", "true");
	        javaMailProperties.put("mail.smtp.auth", "true");
	        javaMailProperties.put("mail.transport.protocol", "smtp");
	        javaMailProperties.put("mail.debug", "true");//Prints out everything on screen
	         
	        mailSender.setJavaMailProperties(javaMailProperties);
	        return mailSender;
	    }
	
		
	}
