package com.day6_portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.day6_portal.service.ApiService;
import com.day6_portal.model.Child;


@RestController
@RequestMapping("/api/v1/day6")
public class ApiController {
	
	@Autowired
	private ApiService apiService;
	
	@GetMapping("/getAllUser")
	public Page<Child> getAllUser(
				@RequestParam(defaultValue = "0") int page, 
				@RequestParam(defaultValue = "5") int size,
				@RequestParam(defaultValue = "id") String sortField,
				@RequestParam(defaultValue = "asc") String sortOrder
			){
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder), sortField));
		return apiService.getAllUser(pageRequest);
	}
	
	@PostMapping("/addChild")
	public ResponseEntity<String>addUser(@RequestBody Child child){
		boolean dataSaved= apiService.adduser(child);
		if(dataSaved) {
			return ResponseEntity.status(200).body("Child info added successfully");
		}
		else {
			return ResponseEntity.status(404).body("Something went wrong");
		}
		
	}

	
	@PutMapping("/updateChild/{babyId}")
	public ResponseEntity<String>updateuser(@PathVariable Long babyId,@RequestBody Child child){
	boolean userData=apiService.updateuser(babyId,child);
	if(userData) {
		return ResponseEntity.status(200).body("Child info updated successfully");
		
	}else {
		return ResponseEntity.status(404).body("No record");
	}

}
	@DeleteMapping("/deleteChild/{babyId}")
	public ResponseEntity<String>deleteUser(@PathVariable Long babyId){
		boolean userDeleted=apiService.deleteUser(babyId);
		if(userDeleted) {
			return ResponseEntity.status(200).body("Child info deleted successfully");
		}
		else {
			return ResponseEntity.status(404).body("No records");
		}
	}
}