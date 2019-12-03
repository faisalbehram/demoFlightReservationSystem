package com.studentdal.app.entites;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;






@Entity
public class Verification {
	@Id
	private String id;
	
	private  String username;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public Verification(String id, String username) {
		super();
		this.id = id;
		this.username = username;
	}
	public Verification(String username) {
		super();
		this.username = username;
	}
	public Verification() {
		
	}
	
	
	
}
