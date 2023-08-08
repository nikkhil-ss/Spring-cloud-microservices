package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@Value("${doc.dept}")
	private String dept;
	
	@GetMapping("/doctors")
	public String showDoctor() {
		return "List of Dooctors from "+dept;
	}
}
