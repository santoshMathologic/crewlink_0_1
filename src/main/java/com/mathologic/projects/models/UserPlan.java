package com.mathologic.projects.models;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;




@Entity
@Table
public class UserPlan implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Column(unique=true)
	private String planName;
	
	
	
	
	//@Column(unique=true,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	//@JsonSerialize(using = LocalDateTimeSerializer.class)
	//@JsonDeserialize(using = LocalDateTimeDeserializer.class)	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	
	@ManyToOne
	//@JsonBackReference
	private User user;
	
	@Column(columnDefinition="BIT(1) DEFAULT b'0'")
	private Boolean isDelete;
	

	public UserPlan() {
		super();
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	

	public String getPlanName() {
		return planName;
	}


	public void setPlanName(String planName) {
		this.planName = planName;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Boolean getIsDelete() {
		return isDelete;
	}


	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}


	public Date getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

}
