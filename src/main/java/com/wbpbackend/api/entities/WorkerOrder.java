package com.wbpbackend.api.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wbpbackend.api.enums.Priority;
import com.wbpbackend.api.enums.Status;

@Entity
public class WorkerOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(pattern = "MM/dd/yyyy HH:mm")
	private LocalDateTime startDate;

	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDateTime endDate;
	private Integer priority;
	private Integer status;
	private String description;

	@ManyToOne
	@JoinColumn(name = "dispatcher_id")
	private Dispatcher dispatcher;

	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Manager manager;

	public WorkerOrder() {
		super();
		this.setStartDate(LocalDateTime.now());
		this.setPriority(Priority.LOW);
		this.setStatus(Status.OPEN);
	}

	public WorkerOrder(Long id, Priority priority, Status status, Dispatcher dispatcher, Manager manager,
			String description) {
		super();
		this.id = id;
		this.setStartDate(LocalDateTime.now());
		this.priority = (priority == null) ? 0 : priority.getCod();
		this.status = (status == null) ? 0 : status.getCod();
		this.description = description;
		this.dispatcher = dispatcher;
		this.manager = manager;
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

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public Priority getPriority() {
		return Priority.toEnum(this.priority);
	}

	public void setPriority(Priority priority) {
		this.priority = priority.getCod();
	}

	public Status getStatus() {
		return Status.toEnum(this.status);
	}

	public void setStatus(Status status) {
		this.status = status.getCod();
	}

	public Dispatcher getDispatcher() {
		return dispatcher;
	}

	public void setDispatcher(Dispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkerOrder other = (WorkerOrder) obj;
		return Objects.equals(id, other.id);
	}

}
