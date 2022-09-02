package com.wbpbackend.api.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.wbpbackend.api.enums.Priority;
import com.wbpbackend.api.enums.Status;

public class WorkerOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Priority priority;
	private Status status;
	private Dispatcher dispatcher;
	private Manager manager;

	public WorkerOrder() {
		super();
	}

	public WorkerOrder(Long id, LocalDateTime startDate, LocalDateTime endDate, Priority priority, Status status,
			Dispatcher dispatcher, Manager manager) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.status = status;
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

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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
