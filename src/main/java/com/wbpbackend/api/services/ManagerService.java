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

import com.wbpbackend.api.dto.ManagerDTO;
import com.wbpbackend.api.entities.Manager;
import com.wbpbackend.api.repositories.ManagerRepository;
import com.wbpbackend.api.services.exceptions.DatabaseException;
import com.wbpbackend.api.services.exceptions.ObjectNotFoundException;

@Service
public class ManagerService {

	@Autowired
	private ManagerRepository managerRepository;

	@Transactional(readOnly = true)
	public ManagerDTO findById(Long id) {
		Optional<Manager> obj = managerRepository.findById(id);
		Manager entity = obj
				.orElseThrow(() -> new ObjectNotFoundException(Manager.class.getName() + " not found! id: " + id));
		return new ManagerDTO(entity);
	}

	@Transactional(readOnly = true)
	public List<ManagerDTO> findAll() {
		List<Manager> list = managerRepository.findAll();
		return list.stream().map(x -> new ManagerDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public ManagerDTO insert(ManagerDTO dto) {
		Manager entity = new Manager(null, dto.getName(), dto.getEmail(), dto.getPhoneNumber());
		entity = managerRepository.save(entity);
		return new ManagerDTO(entity);
	}

	@Transactional
	public ManagerDTO update(Long id, ManagerDTO dto) {
		try {
			Manager entity  = managerRepository.getReferenceById(id);
			entity.setName(dto.getName());
			entity = managerRepository.save(entity);
			return new ManagerDTO(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ObjectNotFoundException("Id not found " + id);
		}
	}
	
	public void delete(Long id) {
		try {
			managerRepository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Id not found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
}
