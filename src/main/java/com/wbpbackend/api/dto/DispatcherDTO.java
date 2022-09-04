package com.wbpbackend.api.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.wbpbackend.api.entities.Dispatcher;

public class DispatcherDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank(message = "The name field is required")
	private String name;

	public DispatcherDTO() {
	}

	public DispatcherDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public DispatcherDTO(Dispatcher entity) {
		super();
		this.id = entity.getId();
		this.name = entity.getName();
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
