package com.wbpbackend.api.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wbpbackend.api.dto.ManagerDTO;
import com.wbpbackend.api.services.ManagerService;

@RestController
@RequestMapping(value = "/managers")
public class ManagerResources {

	@Autowired
	private ManagerService managerService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ManagerDTO> findById(@PathVariable Long id) {
		ManagerDTO dto = managerService.findById(id);
		
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<ManagerDTO>> findAll(){
		List<ManagerDTO> list = managerService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<ManagerDTO> insert(@Valid @RequestBody ManagerDTO dto){
		dto = managerService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ManagerDTO> updated(@PathVariable Long id,@Valid  @RequestBody ManagerDTO dto) {
		dto = managerService.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ManagerDTO> delete(@PathVariable Long id){
		managerService.delete(id);
		return ResponseEntity.noContent().build();   
	}

	
	
}
