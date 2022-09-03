package com.wbpbackend.api.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Dispatcher extends Person implements Serializable{
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "dispatcher")
	private List<WorkerOrder> list = new ArrayList<>();
	
	public Dispatcher() {
		super();
	}

	public Dispatcher(Long id, String name) {
		super(id, name);
	}

	public List<WorkerOrder> getList() {
		return list;
	}

	public void setList(List<WorkerOrder> list) {
		this.list = list;
	}

	
	
	
	
	
	
}

