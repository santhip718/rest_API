package com.day2_portal.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class ApiController {

	@Value("${spring.application.name}")
	private String name;
	
	@GetMapping("/day2")
	public ResponseEntity<String>putData(){
		name="Messi";
		return ResponseEntity.status(200).body(name);
	}
}