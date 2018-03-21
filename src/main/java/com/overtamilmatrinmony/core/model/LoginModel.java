package com.overtamilmatrinmony.core.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Service;

@Entity
@Table(name = "LOGIN")
@Service("loginModel")
public class LoginModel implements Serializable
	{

		/*
		 * @Id
		 * 
		 * @Column(name = "LOGINID")
		 * 
		 * @GeneratedValue(strategy = GenerationType.AUTO) private long loginId;
		 */

		@Id
		// @Column(name = "USERID")
		@GeneratedValue(generator = "uid")
		@GenericGenerator(strategy = "increment", name = "uid", parameters = @Parameter(name = "property", value = "user"))
		private long userId;

		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "userId")
		private UserModel user;

		@Column(name = "PASSWORD", nullable = false)
		// @ColumnTransformer(read = “pgp_sym_decrypt(creditCardNumber, ‘mySecretKey’)”,
		// write = “pgp_sym_encrypt(?, ‘mySecretKey’)”)
		private String password;

		@Column(name = "USERLOGINID", unique = true, nullable = false)
		private String userLoginId;

		@Column(name = "STARTDATE") // , columnDefinition = "DATE DEFAULT CURRENT_DATE")
		private java.sql.Date startDate;

		@Column(name = "EXPIRYDATE") // , columnDefinition = "DATE DEFAULT CURRENT_DATE")
		private java.sql.Date expiryDate;

		@Column(name = "ISADIMN")
		private boolean isAdmin;

		@Column(name = "ACTIVE")
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

		public UserModel getUser()
			{
				return user;
			}

		public void setUser(UserModel user)
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
