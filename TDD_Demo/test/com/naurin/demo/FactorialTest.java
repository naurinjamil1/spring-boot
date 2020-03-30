package com.naurin.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class FactorialTest {

	IFactorial fixture;
	@BeforeEach
	void setUp() throws Exception {
		fixture =  new Factorial();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFactorialOfZero() {
		Assertions.assertEquals(1, fixture.calculateFactorial(0));
	}
	
	@Test
	void testFactorialOfOne() {
		Assertions.assertEquals(1, fixture.calculateFactorial(1));
	}
	
	@Test
	void testFactorialOfN() {
		Assertions.assertEquals(120, fixture.calculateFactorial(5));
	}

	@Nested
	class ErrorHandlingTest{
		@Test
		void testException() {
			Exception e = Assertions.assertThrows(IllegalArgumentException.class, ()->fixture.calculateFactorial(-5));
			Assertions.assertEquals("Negetive number factorial does not exist.", e.getMessage());
		}
	}
}
