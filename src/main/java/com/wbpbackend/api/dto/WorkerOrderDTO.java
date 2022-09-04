package com.wbpbackend.api.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wbpbackend.api.entities.WorkerOrder;

public class WorkerOrderDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@JsonFormat(pattern = "MM/dd/yyyy HH:mm")
	private LocalDateTime startDate;
	
	@JsonFormat(pattern = "MM/dd/yyyy HH:mm")
	private LocalDateTime endDate;
	
	private Integer priority;
	private Integer status;
	
	@NotBlank(message = "The name field is required")
	private String description;
	
	private DispatcherDTO dispatcher;
	
	private ManagerDTO manager;
	
	public WorkerOrderDTO() {
		super();
	}

		public WorkerOrderDTO(Long id, LocalDateTime startDate, LocalDateTime endDate, Integer priority, Integer status,
			@NotBlank(message = "The name field is required") String description, DispatcherDTO dispatcher,
			ManagerDTO manager) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.status = status;
		this.description = description;
		this.dispatcher = dispatcher;
		this.manager = manager;
	}



	public WorkerOrderDTO(WorkerOrder entity) {
		this.id = entity.getId();
		this.startDate = entity.getStartDate();
		this.endDate = entity.getEndDate();
		this.priority = entity.getPriority().getCod();
		this.status = entity.getStatus().getCod();
		this.description = entity.getDescription();
		this.dispatcher = new DispatcherDTO(entity.getDispatcher());
		this.manager = new ManagerDTO(entity.getManager());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DispatcherDTO getDispatcher() {
		return dispatcher;
	}

	public void setDispatcher(DispatcherDTO dispatcher) {
		this.dispatcher = dispatcher;
	}

	public ManagerDTO getManager() {
		return manager;
	}

	public void setManager(ManagerDTO manager) {
		this.manager = manager;
	}


	
	
	

	
	
	
}
