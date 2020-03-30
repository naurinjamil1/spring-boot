package naurin.demo.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import naurin.demo.model.Service;
import naurin.demo.repository.ServiceRepository;

@RestController
@RequestMapping("/api/service")
public class ServiceController {

	@Autowired
	private ServiceRepository repository;
	
	
	@GetMapping("/{id}")
	//@Operation(summary = "Read endpoint", security = @SecurityRequirement(name = "basicAuth"))
	public ResponseEntity<Object> getServiceById(@PathVariable long id) {
		
		Optional<Service> service = repository.findById(id);
		if(service.equals(null)) {
			//throw new ServiceNotFoundException();
			return ResponseEntity.notFound().build();			
		} else {
			return ResponseEntity.ok(service);
		}
		
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> postService(@NotNull @Valid @RequestBody final Service service) {
		
		repository.add(service);
		// create resource location
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(service.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Service updateBook(@PathVariable long id, @RequestBody final Service service) {
		repository.update(id, service);
		return service;
	}
	
	@DeleteMapping("/{id})")
	@ResponseStatus(HttpStatus.OK)
	public long deleteService(@PathVariable final long id) {
		repository.delete(id);
		return id;
	}
}
