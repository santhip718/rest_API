package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired

	EmployeeService Empser;
	
	@PostMapping("addEmployee")
	public Employee add(@RequestBody Employee EE) {
		return Empser.saveDetails(EE);
	}
	@GetMapping("showDetails")
	public List<Employee> show(){
		return Empser.getDetails();
	}
	@GetMapping("showDetailsById/{id}")
	public Optional<Employee> showById(@PathVariable int id){
		return Empser.getById(id);
	}
	@PutMapping("updateEmployee")
	public Employee update(@RequestBody Employee E) {
		return Empser.changeDetails(E);
	}
	@PutMapping("updateEmployeeByID/{id}")
	public ResponseEntity<String> updateById(@PathVariable int id,@RequestBody Employee E) {
		Empser.updateEmployeeById(id, E);
		return ResponseEntity.ok("Updated Sucessufully");
	}
	@DeleteMapping("deleteEmployees")
	public String delete(@RequestBody Employee E) {
		Empser.deleteDetails(E);
		return "Deleted sucessfully";
	}
	@DeleteMapping("deleteEmployeesbyId/{id}")
	public String deleteDetailsById(@PathVariable int  id) {
		Empser.deleteDetailsById(id);
		return "Deleted by id sucessfully";
	}
	
}
