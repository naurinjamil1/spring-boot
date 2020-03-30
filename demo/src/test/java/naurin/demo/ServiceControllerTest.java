package naurin.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import naurin.demo.controller.ServiceController;
import naurin.demo.model.Service;
import naurin.demo.repository.ServiceRepository;

import org.junit.platform.runner.JUnitPlatform;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class ServiceControllerTest {

	@InjectMocks
	ServiceController serviceController;
	
	@Mock
	ServiceRepository mockedServiceRepo;
	Service newService;
	
	@BeforeEach
	public void setUp() {
		newService = new Service();
	    newService.setId(001234);
	    newService.setName("Demo_Service");
	}
	
	@Test
	public void testPostService() {
		
		 MockHttpServletRequest request = new MockHttpServletRequest();
	     RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	     
	     Mockito.when(mockedServiceRepo.add(newService)).thenReturn(true);
	     
	     ResponseEntity<Object> responsePost = serviceController.postService(newService);
	     assertThat(responsePost.getStatusCodeValue()).isEqualTo(201);
	     assertThat(responsePost.getHeaders().getLocation().getPath()).isEqualTo("/" + newService.getId());
	}
	
	@Test
	public void testGetService() {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		Mockito.when(mockedServiceRepo.findById(001234)).thenReturn(Optional.of(newService));
		
		ResponseEntity<Object> responseGetAdded = serviceController.getServiceById(newService.getId());
		assertThat(responseGetAdded.getStatusCodeValue()).isEqualTo(200);
		assertThat(responseGetAdded.getBody().equals(newService));
		
	}
}
