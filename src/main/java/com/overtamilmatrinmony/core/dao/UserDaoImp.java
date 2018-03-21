package com.overtamilmatrinmony.core.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.overtamilmatrinmony.core.model.LoginModel;
import com.overtamilmatrinmony.core.model.ReferenceModel;
import com.overtamilmatrinmony.core.model.UserDetailModel;
import com.overtamilmatrinmony.core.model.UserModel;

@Repository
public class UserDaoImp implements UserDao
	{

		@Autowired
		private SessionFactory sessionFactory;

		@Override
		public long save(UserModel user)
			{
				sessionFactory.getCurrentSession().save(user);
				return user.getUserId();
			}

		@Override
		public UserModel get(long id)
			{
				return sessionFactory.getCurrentSession().get(UserModel.class, id);
			}

		@Override
		public long registor(UserModel user)
			{
				Session session = sessionFactory.openSession();
				session.beginTransaction();

				session.save(user);
				session.getTransaction().commit();
				session.close();
				System.out.println(" User DAO::" + user.toString() + " User reff:" + user.getReference().size());
				System.out.println(" user::: id: " + user.getUserId());
				return user.getUserId();
			}

		@Override
		public UserModel getUser(int id) throws Exception
			{
				// TODO Auto-generated method stub
				return null;
			}

		@Override
		public void editReference(List<ReferenceModel> referenceModel, UserModel user) throws Exception
			{
				 
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					user.setReference(referenceModel);
					session.saveOrUpdate(user);
					session.getTransaction().commit();
					session.close();
					System.out.println(" Edit Reference DAO:: User reff:" + user.getReference().size());
					return ;
				
			}

		@Override
		public void editUserDetails(UserDetailModel userDetails, UserModel userModel) throws Exception
			{
				

				Session session = sessionFactory.openSession();
				session.beginTransaction();
				userModel.setUserDetail(userDetails);
				session.saveOrUpdate(userModel);
				session.getTransaction().commit();
				session.close();
				System.out.println(" Edit Reference DAO:: User reff:" + userDetails.toString());
				return ;
				
			}

	}
