package com.overtamilmatrinmony.core.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

public class Reference implements Serializable
	{

		private Long referenceId;

		public Long getReferenceId()
			{
				return referenceId;
			}

		public void setReferenceId(Long referenceId)
			{
				this.referenceId = referenceId;
			}

		public String getName()
			{
				return name;
			}

		public void setName(String name)
			{
				this.name = name;
			}

		public String getRelationship()
			{
				return relationship;
			}

		public void setRelationship(String relationship)
			{
				this.relationship = relationship;
			}

		public User getUser()
			{
				return user;
			}

		public void setUser(User user)
			{
				this.user = user;
			}

		private String name;

		private String relationship;

		private User user;

		public String toString()
			{
				StringBuffer strBuff = new StringBuffer();

				strBuff.append("Name : ").append("");

				return strBuff.toString();
			}
	}
