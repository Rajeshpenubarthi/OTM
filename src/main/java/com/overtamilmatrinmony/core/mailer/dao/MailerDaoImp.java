package com.overtamilmatrinmony.core.mailer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.overtamilmatrinmony.core.mailer.model.MailDetail;
import com.overtamilmatrinmony.core.model.LoginModel;
import com.overtamilmatrinmony.core.model.ReferenceModel;
import com.overtamilmatrinmony.core.model.UserDetailModel;
import com.overtamilmatrinmony.core.model.UserModel;

@Repository
public class MailerDaoImp implements MailerDao
	{

		@Autowired
		private SessionFactory sessionFactory;

		@Override
		public void sendWelcomeMail(MailDetail mailDetail) throws Exception
			{
				Session session = sessionFactory.openSession();
				session.beginTransaction();

				session.save(mailDetail);
				session.getTransaction().commit();
				session.close();
			
				return ;
				
			}

			}
