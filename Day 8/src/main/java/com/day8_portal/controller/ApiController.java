package com.day8_portal.controller;

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

import com.day8_portal.model.Bike;
import com.day8_portal.service.ApiService;


@RestController
@RequestMapping("/api/v1/day8")
public class ApiController {
	
	@Autowired
	private ApiService apiService;
	
	@PostMapping("/addBike")
	public ResponseEntity<String>addBike(@RequestBody Bike bike){
		boolean dataSaved= apiService.addBike(bike);
		if(dataSaved) {
			return ResponseEntity.status(200).body("Bike details added successfully");
		}
		else {
			return ResponseEntity.status(404).body("Something went wrong");
		}
		
	}
	
	@GetMapping("/getQuery")
	public ResponseEntity<List<Bike>>findAllQuery(){
		return ResponseEntity.status(200).body(apiService.findAllQuery());
	}

}

