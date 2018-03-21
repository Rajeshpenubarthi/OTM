package com.overtamilmatrinmony.core.mailer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import com.overtamilmatrinmony.core.dto.User;
import com.overtamilmatrinmony.core.mailer.dao.MailerDao;
import com.overtamilmatrinmony.core.mailer.model.MailDetail;
import com.overtamilmatrinmony.core.model.UserModel;
import com.overtamilmatrinmony.core.service.UserService;

@Service("mailerService")
@PropertySource("classpath:mail.properties")
@EnableScheduling
public class MailerServicesImpl implements MailerServices
	{

		@Autowired
		private MailerDao mailerService;


		@Override
		public void triggerMailer()
			{
				// TODO Auto-generated method stub

			}

		@Override
		public void sendWelcomeMail(User user) throws Exception
			{
				MailDetail mailDetail=new MailDetail();
				mailDetail.setUserId(user.getUserId());
				mailDetail.setUserName(user.getName()+ " "+user.getUserDetail().getLName());
				mailDetail.setTo(user.getUserDetail().getEmail());
				mailDetail.setSend(false);
				mailerService.sendWelcomeMail(mailDetail);
			}

		
	}
