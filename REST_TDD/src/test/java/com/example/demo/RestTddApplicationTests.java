package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dependencies.Factorial;

@SpringBootTest
class RestTddApplicationTests {

	Factorial mockObject = mock(Factorial.class);
	@BeforeEach
	public void setup() {
		when(mockObject.calculateFactorial(5)).thenReturn((long)120);
	}
	
	@Test
	public void testFactorial() {
		assertEquals(120, mockObject.calculateFactorial(5));
	}

}
