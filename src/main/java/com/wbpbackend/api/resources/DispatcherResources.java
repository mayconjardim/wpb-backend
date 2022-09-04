package com.wbpbackend.api.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping
	public ResponseEntity<List<DispatcherDTO>> findAll(){
		List<DispatcherDTO> list = dispatcherService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<DispatcherDTO> insert(@Valid @RequestBody DispatcherDTO dto){
		dto = dispatcherService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<DispatcherDTO> updated(@PathVariable Long id,@Valid  @RequestBody DispatcherDTO dto) {
		dto = dispatcherService.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	
	
}
