package com.dev.restv1.restapi.user;

import java.util.Date;


import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//Static Filtering with this line
//@JsonIgnoreProperties(value = {"birthDate"})
//Dynamic Filtering Requirment
@JsonFilter("NameFilter")
public class User {
	
	private Integer id;
	@Size(min =2,message = "Name should have atleast two character")
	private String name;
	@Past
	private Date birthDate;
	
	
	//Created as it gives error still need to check why
	//Update new spring version dont need this
	protected User() {
		
	}
	
	
	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	
	
	

}
