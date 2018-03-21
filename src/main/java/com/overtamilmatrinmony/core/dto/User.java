package com.overtamilmatrinmony.core.dto;

import java.io.Serializable;
import java.util.List;

import com.overtamilmatrinmony.core.model.LoginModel;
import com.overtamilmatrinmony.core.model.ReferenceModel;

public class User implements Serializable
	{

		private String			name;
		private String			userLoginId;
		private UserDetail		userDetail;
		private Long			userId;
		private List<Reference>	reference;
		private Login			login;

		public Login getLogin()
			{
				return login;
			}

		public void setLogin(Login login)
			{
				this.login = login;
			}

		public String getUserLoginId()
			{
				return userLoginId;
			}

		public void setUserLoginId(String userLoginId)
			{
				this.userLoginId = userLoginId;
			}

		public String getName()
			{
				return name;
			}

		public void setName(String name)
			{
				this.name = name;
			}

		public UserDetail getUserDetail()
			{
				return this.userDetail;
			}

		public void setUserDetail(UserDetail userDetail)
			{
				this.userDetail = userDetail;
			}

		public Long getUserId()
			{
				return this.userId;
			}

		public void setUserId(Long userId)
			{
				this.userId = userId;
			}

		public List<Reference> getReference()
			{
				return reference;
			}

		public void setReference(List<Reference> reference)
			{
				this.reference = reference;
			}

		@Override
		public String toString()
			{
				StringBuffer strBuff = new StringBuffer();

				strBuff.append(" Name : ").append(getName());
				strBuff.append(", Password : ").append(getName());
				strBuff.append(",User LoginId : ").append(getUserLoginId());
				strBuff.append(", UserDetail : { ").append(userDetail.toString() + "}");

				return strBuff.toString();
			}
	}
