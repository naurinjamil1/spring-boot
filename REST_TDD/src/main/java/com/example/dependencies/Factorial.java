package com.example.dependencies;

public class Factorial implements IFactorial {

	@Override
	public long calculateFactorial(int n) {
		
		if(n < 0)
			throw new IllegalArgumentException("Negetive number factorial does not exist.");
		if(n == 0 || n == 1)
			return 1;
		return n * calculateFactorial(n - 1);
		
	}

}
