package com.mathologic.projects.models;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table
public class Role {

	
	 @Id
	 @GeneratedValue
	 Long id;
	 
	 @NotNull
	 @Column(unique=true)
	 private String name;
	
	 @OneToMany(mappedBy="role",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	 //@JsonBackReference
	 private List<User> users = new LinkedList<User>();
	    
	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
