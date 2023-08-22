package com.day1_portal.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class ApiController {
	@GetMapping("/day1Welcome")
	public ResponseEntity<String>Welcome(){
		return ResponseEntity.status(200).body("Welcome String Boot!");
	}
	
	@GetMapping("/day1Name")
	public ResponseEntity<String>getName(){
		return ResponseEntity.status(200).body("Welcome Vivin");
	}
	
	@GetMapping("/day1Color")
	public ResponseEntity<String>getMyFav(){
		return ResponseEntity.status(200).body("My favorite color is Violet");
	}

}