package com.overtamilmatrinmony.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Entity
@Table(name = "COUNTRY")
@Service("country")
public class Country implements Serializable
	{

		@Id
		@Column(name = "COUNTRYID", unique = true, nullable = false)
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long countryrId;

		public Long getCountryrId()
			{
				return countryrId;
			}

		public void setCountryrId(Long countryrId)
			{
				this.countryrId = countryrId;
			}

		@Column(name = "NAME", nullable = false)
		private String name;

		@Column(name = "CITY", nullable = false)
		private String		city;
		private String[]	cityNames;

		public String getName()
			{
				return name;
			}

		public void setName(String name)
			{
				this.name = name;
			}

		public String getCity()
			{
				return city;
			}

		public void setCity(String city)
			{
				this.city = city;
			}

		/*
		 * @Override public String toString() { StringBuffer strBuff = new
		 * StringBuffer(); strBuff.append("id : ").append(getUserId());
		 * strBuff.append(", name : ").append(getName());
		 * strBuff.append(", mobile : ").append(getMobile()); return strBuff.toString();
		 * }
		 */}
