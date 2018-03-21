package com.overtamilmatrinmony.core.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

@Entity
@Table(name = "USER")
@Service("userModel")
public class UserModel implements Serializable
	{

		@Id
		@Column(name = "USERID")
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		private long userId;

		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "USERID")
		private LoginModel login;

		@Column(name = "NAME", nullable = false)
		private String name;

		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "USERID")
		private UserDetailModel userDetail;

		@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
		private List<ReferenceModel> reference;

		public String getName()
			{
				return name;
			}

		public void setName(String name)
			{
				this.name = name;
			}

		public UserDetailModel getUserDetail()
			{
				return this.userDetail;
			}

		public void setUserDetail(UserDetailModel userDetail)
			{
				this.userDetail = userDetail;
			}

		public LoginModel getLogin()
			{
				return login;
			}

		public void setLogin(LoginModel login)
			{
				this.login = login;
			}

		public long getUserId()
			{
				return userId;
			}

		public void setUserId(long userId)
			{
				this.userId = userId;
			}

		public List<ReferenceModel> getReference()
			{
				return reference;
			}

		public void setReference(List<ReferenceModel> reference)
			{
				this.reference = reference;
			}

		@Override
		public String toString()
			{
				StringBuffer strBuff = new StringBuffer();

				strBuff.append(" Name : ").append(getName());

				strBuff.append(", UserDetail : { ").append(userDetail.toString() + "}");

				return strBuff.toString();
			}
	}
