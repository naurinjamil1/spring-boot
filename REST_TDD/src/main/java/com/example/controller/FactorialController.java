package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dependencies.Factorial;
import com.example.dependencies.IFactorial;
import com.example.model.Result;

public class FactorialController {
	
	@GetMapping("factorial/{number}")
	public @ResponseBody Result factorial(@PathVariable int number) {
		IFactorial fact = new Factorial();
		Result result = new Result(fact.calculateFactorial(number));
		return result;
	}

}
