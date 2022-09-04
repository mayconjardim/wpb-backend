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

import com.wbpbackend.api.dto.WorkerOrderDTO;
import com.wbpbackend.api.services.WorkerOrderService;

@RestController
@RequestMapping(value = "/orders")
public class WorkerOrderResources {

	@Autowired
	private WorkerOrderService orderService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<WorkerOrderDTO> findById(@PathVariable Long id) {
		WorkerOrderDTO dto = orderService.findById(id);
		
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<WorkerOrderDTO>> findAll(){
		List<WorkerOrderDTO> list = orderService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<WorkerOrderDTO> insert(@Valid @RequestBody WorkerOrderDTO dto){
		dto = orderService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<WorkerOrderDTO> updated(@PathVariable Long id,@Valid  @RequestBody WorkerOrderDTO dto) {
		dto = orderService.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<WorkerOrderDTO> delete(@PathVariable Long id){
		orderService.delete(id);
		return ResponseEntity.noContent().build();   
	}
	

	
	
}
