package com.overtamilmatrinmony.core.utility;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.overtamilmatrinmony.core.config.OTMMailerConfig;
import com.overtamilmatrinmony.core.mailer.service.MailerServices;

public class TriggerMailer
	{

		public static void main(String[] args)
			{
			    ApplicationContext context = new AnnotationConfigApplicationContext(OTMMailerConfig.class);

			    MailerServices mailer=(MailerServices) context.getBean("MailerServices");
			    mailer.triggerMailer();
			}

	}
