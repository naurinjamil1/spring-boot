package naurin.demo.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import naurin.demo.model.Service;

@Repository
public class ServiceRepository {
	
	private Map<Long, Service> services = new HashMap<>();
	
	public Optional<Service> findById(long id) {
		return Optional.ofNullable(services.get(id));
	}
	
	public boolean add(Service service) {
		services.put(service.getId(), service);
		return true;
	}
	
	public Collection<Service> getAll(){
		return services.values();
	}
	
	public Service update(long id, Service service) {
		services.replace(id, service);
		return services.get(id);
	}
	
	public void delete(long id) {
		services.entrySet().removeIf(e -> e.getKey().equals(id));		
	}
}
