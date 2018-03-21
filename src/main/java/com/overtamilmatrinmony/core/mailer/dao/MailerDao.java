package com.overtamilmatrinmony.core.mailer.dao;

import java.util.List;

import com.overtamilmatrinmony.core.mailer.model.MailDetail;


public interface MailerDao
	{

	public void sendWelcomeMail(MailDetail mailDetail) throws Exception;

	}
