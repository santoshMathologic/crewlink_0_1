package com.mathologic.projects.models;


import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mathologic.projects.utils.LocalDateTimeConverter;
import com.mathologic.projects.utils.LocalDateTimeDeserializer;
import com.mathologic.projects.utils.LocalDateTimeSerializer;




@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
	
	
	
	
	@Column(unique=true,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	//@JsonSerialize(using = LocalDateTimeSerializer.class)
	//@JsonDeserialize(using = LocalDateTimeDeserializer.class)	
	//@Temporal(TemporalType.TIMESTAMP)
	
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime createdOn = LocalDateTime.now() ;
	
	
	@ManyToOne
	//@JsonBackReference
	@JoinColumn(name = "user")
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


	public LocalDateTime getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}


	

}
