package com.unittest.codecoverage.models;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
	
	private static final long serialVersionUID = -3254533058084174470L;
	
	private Long id;
	private String firstname;
	private String lastname;
	private Date birthday;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
