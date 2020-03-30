package naurin.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {
	
	@ExceptionHandler(ServiceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<String> handleServiceNotFoundException(RuntimeException exception){
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

}
