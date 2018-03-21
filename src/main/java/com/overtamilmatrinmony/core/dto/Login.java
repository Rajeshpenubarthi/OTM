package com.overtamilmatrinmony.core.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

public class Login implements Serializable
	{

		private Long loginId;

		private User user;

		public Long getLoginId()
			{
				return loginId;
			}

		public void setLoginId(Long loginId)
			{
				this.loginId = loginId;
			}

		private String password;

		private String userLoginId;

		private java.sql.Date startDate;

		private java.sql.Date expiryDate;

		private boolean isAdmin;

		private boolean active;

		public String getPassword()
			{
				return password;
			}

		public void setPassword(String password)
			{
				this.password = password;
			}

		public String getUserLoginId()
			{
				return userLoginId;
			}

		public void setUserLoginId(String userLoginId)
			{
				this.userLoginId = userLoginId;
			}

		public boolean isAdmin()
			{
				return isAdmin;
			}

		public void setAdmin(boolean isAdmin)
			{
				this.isAdmin = isAdmin;
			}

		public boolean isActive()
			{
				return active;
			}

		public void setActive(boolean active)
			{
				this.active = active;
			}

		public User getUser()
			{
				return user;
			}

		public void setUser(User user)
			{
				this.user = user;
			}

		public java.sql.Date getStartDate()
			{
				return startDate;
			}

		public void setStartDate(java.sql.Date startDate)
			{
				this.startDate = startDate;
			}

		public java.sql.Date getExpiryDate()
			{
				return expiryDate;
			}

		public void setExpiryDate(java.sql.Date expiryDate)
			{
				this.expiryDate = expiryDate;
			}

		@Override
		public String toString()
			{
				StringBuffer strBuff = new StringBuffer();

				strBuff.append(",User LoginId : ").append(getUserLoginId());

				return strBuff.toString();
			}
	}
