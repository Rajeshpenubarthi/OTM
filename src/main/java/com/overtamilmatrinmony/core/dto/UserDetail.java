package com.overtamilmatrinmony.core.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class UserDetail implements Serializable
	{
		private Long	userId;
		private String	lName;
		private String	gender;
		private String	email;
		private User	user;
		private String	education;

		public String getEducation()
			{
				return education;
			}

		public void setEducation(String education)
			{
				this.education = education;
			}

		public User getUser()
			{
				return this.user;
			}

		public void setUser(User user)
			{
				this.user = user;
			}

		public Long getUserId()
			{
				return userId;
			}

		public void setUserId(Long userId)
			{
				this.userId = userId;
			}

		public String getLName()
			{
				return lName;
			}

		public void setLName(String lName)
			{
				this.lName = lName;
			}

		public String getGender()
			{
				return gender;
			}

		public void setGender(String gender)
			{
				this.gender = gender;
			}

		public String getEmail()
			{
				return email;
			}

		public void setEmail(String email)
			{
				this.email = email;
			}

		@Override
		public String toString()
			{
				StringBuffer strBuff = new StringBuffer();
				strBuff.append("Last Name : ").append(getLName());
				strBuff.append(", Gender  : ").append(getGender());
				strBuff.append(",Email : ").append(getEmail());
				return strBuff.toString();
			}
	}
