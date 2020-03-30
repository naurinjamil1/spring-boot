package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Message;

public class HelloWorldController {
	
	@GetMapping("greetings/{name}")
	public @ResponseBody Message greeting(@PathVariable String name) {
		return new Message();
	}

}
