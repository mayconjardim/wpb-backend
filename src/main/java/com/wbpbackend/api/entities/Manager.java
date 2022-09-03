package com.wbpbackend.api.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Manager extends Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "manager")
	private List<WorkerOrder> list = new ArrayList<>();
	
	@NotBlank
	private String phoneNumber;
	@NotBlank
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

	public List<WorkerOrder> getList() {
		return list;
	}

	public void setList(List<WorkerOrder> list) {
		this.list = list;
	}

	
	
}
