package com.overtamilmatrinmony.core.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
	{

		@Override
		protected Class<?>[] getRootConfigClasses()
			{
				return new Class[]
					{ OTMMailerConfig.class,ThymeleafConfig.class,OTMConfig.class };
			}

		@Override
		protected Class<?>[] getServletConfigClasses()
			{
				return new Class[]
					{ WebConfig.class };
			}

		@Override
		protected String[] getServletMappings()
			{
				return new String[]
					{ "/" };
			}
	}
