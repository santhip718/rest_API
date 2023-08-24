package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@CrossOrigin("http://localhost:3000")
public class EmployeeController {
	@Autowired

	EmployeeService Empser;
	
	@PostMapping("user")
	public Employee add(@RequestBody Employee EE) {
		return Empser.saveDetails(EE);
	}
	@GetMapping("data")
	public List<Employee> show(){
		return Empser.getDetails();
	}
}
	