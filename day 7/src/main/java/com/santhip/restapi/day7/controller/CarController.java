package com.santhip.restapi.day7.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santhip.restapi.day7.model.CarModel;
import com.santhip.restapi.day7.service.CarService;

@RestController
@RequestMapping("/api/v1/user")
public class CarController {
	@Autowired
	CarService css;
	@PostMapping("/post")
	public CarModel save(@RequestBody CarModel data) {
		return css.save(data);
	}
	
	@GetMapping("owner/{data}")
	public List<CarModel> getByOwn(@PathVariable int data){
		return css.getByOwn(data);
	}
	
	@GetMapping("address/{address}")
	public List<CarModel> getByAddr(@PathVariable String address){
		return css.getByAddr(address);
	}
	@GetMapping("carname/{carname}")
	public List<CarModel> getByName(@PathVariable String carname){
		return css.getByName(carname);
	}
	@GetMapping("owners/{owners}/cartype/{cartype}")
	public List<CarModel> getByBoth(@PathVariable int owners, @PathVariable String cartype){
		return css.getBoth(owners, cartype);
	}
}