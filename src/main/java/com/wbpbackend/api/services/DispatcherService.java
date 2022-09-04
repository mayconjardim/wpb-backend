package com.wbpbackend.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbpbackend.api.dto.DispatcherDTO;
import com.wbpbackend.api.entities.Dispatcher;
import com.wbpbackend.api.repositories.DispatcherRepository;

@Service
public class DispatcherService {

	@Autowired
	private DispatcherRepository dispatcherRepository;

	public DispatcherDTO findById(Long id) {
		Optional<Dispatcher> obj = dispatcherRepository.findById(id);
		Dispatcher entity = obj.orElse(null);
		return new DispatcherDTO(entity);
	}

}
