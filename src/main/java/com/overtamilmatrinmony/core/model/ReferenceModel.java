package com.overtamilmatrinmony.core.model;

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

@Entity
@Table(name = "REFERENCE")
@Service("referenceModel")
public class ReferenceModel implements Serializable
	{

		@Id
		@Column(name = "REFERENCEID")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long referenceId;

		@Column(name = "NAME", nullable = false)
		private String name;

		@Column(name = "RELATIONSHIP", nullable = false)
		private String relationship;

		@ManyToOne
		// @JoinColumn(name="USERID", nullable=false)
		private UserModel user;

		public long getReferenceId()
			{
				return referenceId;
			}

		public void setReferenceId(long referenceId)
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

		public UserModel getUser()
			{
				return user;
			}

		public void setUser(UserModel user)
			{
				this.user = user;
			}

		@Override
		public String toString()
			{
				StringBuffer strBuff = new StringBuffer();

				strBuff.append("Name : ").append("");

				return strBuff.toString();
			}
	}
