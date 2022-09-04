package com.wbpbackend.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wbpbackend.api.dto.DispatcherDTO;
import com.wbpbackend.api.services.DispatcherService;

@RestController
@RequestMapping(value = "/dispatchers")
public class DispatcherResources {

	@Autowired
	private DispatcherService dispatcherService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<DispatcherDTO> findById(@PathVariable Long id) {
		DispatcherDTO dto = dispatcherService.findById(id);
		
		return ResponseEntity.ok().body(dto);
	}

}