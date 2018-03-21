package com.overtamilmatrinmony.core.model;

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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Entity
@Table(name = "USERDETAIL")
@Service("userDetailModel")
public class UserDetailModel implements Serializable
	{

		@Id
		// @Column(name = "USERID")
		@GeneratedValue(generator = "uid")
		@GenericGenerator(strategy = "increment", name = "uid", parameters = @Parameter(name = "property", value = "user"))
		private long userId;

		/*
		 * @Id
		 * 
		 * @Column(name = "UDID")
		 * 
		 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Long uDId;
		 */
		public long getUserDetId()
			{
				return userId;
			}

		public void setUserId(long userId)
			{
				this.userId = userId;
			}

		@Column(name = "relocate")
		private boolean isRelocate;

		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "userId")
		private UserModel user;

		@Column(name = "LASTNAME", nullable = false)
		private String lName;

		@Column(name = "GENDER", nullable = false)
		private String gender;

		@Column(name = "EMAIL", nullable = false)
		private String email;

		@Column(name = "BIRTHDATE") // , columnDefinition = "DATE DEFAULT CURRENT_DATE")
		private java.sql.Date birthDate;

		@Column(name = "EDUCATION", nullable = false)
		private String education;

		public java.sql.Date getBirthDate()
			{
				return birthDate;
			}

		public void setBirthDate(java.sql.Date birthDate)
			{
				this.birthDate = birthDate;
			}

		public String getEducation()
			{
				return education;
			}

		public void setEducation(String education)
			{
				this.education = education;
			}

		public boolean isRelocate()
			{
				return isRelocate;
			}

		public void setRelocate(boolean isRelocate)
			{
				this.isRelocate = isRelocate;
			}

		public UserModel getUser()
			{
				return this.user;
			}

		public void setUser(UserModel user)
			{
				this.user = user;
			}

		/*
		 * public Long getUDId() { return uDId; }
		 * 
		 * public void setUDId(Long uDId) { this.uDId = uDId; }
		 */
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
