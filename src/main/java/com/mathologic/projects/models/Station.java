package com.mathologic.projects.models;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by vivek on 3/10/15.
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "station")
public class Station implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Column(unique = true)
	private String code;

	private String name;

	@Column(columnDefinition="BIGINT DEFAULT 30")
	private Long headStationSignOnDuration = 30L;

	@Column(columnDefinition="BIGINT DEFAULT 30")
	private Long headStationSignOffDuration= 30L;
	
	@Column(columnDefinition="INT DEFAULT 1")
	private Integer numberOfBeds= 1;

	@Column(columnDefinition="BIGINT DEFAULT 30")
	private Long outStationSignOnDuration= 30L;

	@Column(columnDefinition="BIGINT DEFAULT 30")
	private Long outStationSignOffDuration= 30L;
	
	
	
	@ManyToMany(mappedBy="Stations", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private List<User> users = new LinkedList<User>();
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getHeadStationSignOnDuration() {
		return headStationSignOnDuration;
	}

	public void setHeadStationSignOnDuration(Long headStationSignOnDuration) {
		this.headStationSignOnDuration = headStationSignOnDuration;
	}

	public Long getHeadStationSignOffDuration() {
		return headStationSignOffDuration;
	}

	public void setHeadStationSignOffDuration(Long headStationSignOffDuration) {
		this.headStationSignOffDuration = headStationSignOffDuration;
	}

	public Integer getNumberOfBeds() {
		return numberOfBeds;
	}

	public void setNumberOfBeds(Integer numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}

	public Long getOutStationSignOnDuration() {
		return outStationSignOnDuration;
	}

	public void setOutStationSignOnDuration(Long outStationSignOnDuration) {
		this.outStationSignOnDuration = outStationSignOnDuration;
	}

	public Long getOutStationSignOffDuration() {
		return outStationSignOffDuration;
	}

	public void setOutStationSignOffDuration(Long outStationSignOffDuration) {
		this.outStationSignOffDuration = outStationSignOffDuration;
	}

	

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	
}
