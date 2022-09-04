package com.wbpbackend.api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wbpbackend.api.dto.WorkerOrderDTO;
import com.wbpbackend.api.entities.WorkerOrder;
import com.wbpbackend.api.enums.Priority;
import com.wbpbackend.api.enums.Status;
import com.wbpbackend.api.repositories.DispatcherRepository;
import com.wbpbackend.api.repositories.ManagerRepository;
import com.wbpbackend.api.repositories.WorkerOrderRepository;
import com.wbpbackend.api.services.exceptions.DatabaseException;
import com.wbpbackend.api.services.exceptions.ObjectNotFoundException;

@Service
public class WorkerOrderService {

	@Autowired
	private WorkerOrderRepository orderRepository;
	
	@Autowired 
	private DispatcherRepository dispatcherRepository;
	
	@Autowired
	private ManagerRepository managerRepository;

	@Transactional(readOnly = true)
	public WorkerOrderDTO findById(Long id) {
		Optional<WorkerOrder> obj = orderRepository.findById(id);
		WorkerOrder entity = obj
				.orElseThrow(() -> new ObjectNotFoundException(WorkerOrder.class.getName() + " not found! id: " + id));
		return new WorkerOrderDTO(entity);
	}

	@Transactional(readOnly = true)
	public List<WorkerOrderDTO> findAll() {
		List<WorkerOrder> list = orderRepository.findAll();
		return list.stream().map(x -> new WorkerOrderDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public WorkerOrderDTO insert(WorkerOrderDTO dto) {
		WorkerOrder entity = new WorkerOrder();
		entity.setId(dto.getId());
		entity.setDescription(dto.getDescription());
		entity.setPriority(Priority.toEnum(dto.getPriority()));
		entity.setStatus(Status.toEnum(dto.getStatus()));
		entity.setDispatcher(dispatcherRepository.getReferenceById(dto.getDispatcher().getId()));
		entity.setManager(managerRepository.getReferenceById(dto.getManager().getId()));
		
		entity = orderRepository.save(entity);
		return new WorkerOrderDTO(entity);
	}


	@Transactional
	public WorkerOrderDTO update(Long id, WorkerOrderDTO dto) {
		try {
			WorkerOrder entity  = orderRepository.getReferenceById(id);
			entity.setDescription(dto.getDescription());
			entity.setPriority(dto.getPriority());
			entity.setStatus(dto.getStatus());
			
			entity = orderRepository.save(entity);
			return new WorkerOrderDTO(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ObjectNotFoundException("Id not found " + id);
		}
	}
	
	public void delete(Long id) {
		try {
			orderRepository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Id not found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
	
}
