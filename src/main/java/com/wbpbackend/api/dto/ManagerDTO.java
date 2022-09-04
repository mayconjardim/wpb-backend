package com.wbpbackend.api.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.wbpbackend.api.entities.Manager;

public class ManagerDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotBlank(message = "The Name field is required")
	private String name;
	
	@NotBlank(message = "The Email field is required")
	private String email;
	
	@NotBlank(message = "The Number field is required")
	private String phoneNumber;

	public ManagerDTO() {
		super();
	}

	public ManagerDTO(Long id, String name, String email, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public ManagerDTO(Manager entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.phoneNumber = entity.getPhoneNumber();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
