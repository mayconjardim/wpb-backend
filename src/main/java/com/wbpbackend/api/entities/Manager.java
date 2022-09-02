package com.wbpbackend.api.entities;

import java.io.Serializable;

public class Manager extends Person implements Serializable {
	private static final long serialVersionUID = 1L;

	private String phoneNumber;
	private String email;
	
	public Manager() {
		super();
	}

	public Manager(Long id, String name, String phoneNumber, String email) {
		super(id, name);
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
