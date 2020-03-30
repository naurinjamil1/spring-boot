package naurin.demo.exception;

@SuppressWarnings("serial")
public class ServiceNotFoundException extends RuntimeException{

	public ServiceNotFoundException() {}
	
	@SuppressWarnings("unused")
	private ServiceNotFoundException(Throwable cause) {}
	
	public ServiceNotFoundException(String message) {
		super(message);
	}
	
	public ServiceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
