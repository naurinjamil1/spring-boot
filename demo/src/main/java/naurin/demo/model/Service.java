package naurin.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Service {
	
	private long id;
	
	@NotBlank
	@Size(min = 0, max = 30)
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
}
