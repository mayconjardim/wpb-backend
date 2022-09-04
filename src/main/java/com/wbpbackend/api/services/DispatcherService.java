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

import com.wbpbackend.api.dto.DispatcherDTO;
import com.wbpbackend.api.entities.Dispatcher;
import com.wbpbackend.api.repositories.DispatcherRepository;
import com.wbpbackend.api.services.exceptions.DatabaseException;
import com.wbpbackend.api.services.exceptions.ObjectNotFoundException;

@Service
public class DispatcherService {

	@Autowired
	private DispatcherRepository dispatcherRepository;

	@Transactional(readOnly = true)
	public DispatcherDTO findById(Long id) {
		Optional<Dispatcher> obj = dispatcherRepository.findById(id);
		Dispatcher entity = obj
				.orElseThrow(() -> new ObjectNotFoundException(Dispatcher.class.getName() + " not found! id: " + id));
		return new DispatcherDTO(entity);
	}

	@Transactional(readOnly = true)
	public List<DispatcherDTO> findAll() {
		List<Dispatcher> list = dispatcherRepository.findAll();
		return list.stream().map(x -> new DispatcherDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public DispatcherDTO insert(DispatcherDTO dto) {
		Dispatcher entity = new Dispatcher(null, dto.getName());
		entity = dispatcherRepository.save(entity);
		return new DispatcherDTO(entity);
	}

	@Transactional
	public DispatcherDTO update(Long id, DispatcherDTO dto) {
		try {
			Dispatcher entity  = dispatcherRepository.getReferenceById(id);
			entity.setName(dto.getName());
			entity = dispatcherRepository.save(entity);
			return new DispatcherDTO(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ObjectNotFoundException("Id not found " + id);
		}
	}
	
	public void delete(Long id) {
		try {
			dispatcherRepository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Id not found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
}
