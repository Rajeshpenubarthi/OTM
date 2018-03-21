package com.overtamilmatrinmony.core.mailer.service;

import com.overtamilmatrinmony.core.dto.User;

public interface MailerServices
	{
		public void triggerMailer();
		public void sendWelcomeMail(User user)throws Exception;

	}
