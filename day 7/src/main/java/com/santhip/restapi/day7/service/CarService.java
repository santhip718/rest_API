package com.santhip.restapi.day7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santhip.restapi.day7.model.CarModel;
import com.santhip.restapi.day7.repository.CarRepo;
@Service
public class CarService {
	@Autowired
	CarRepo crep;
	
	public CarModel save(CarModel data) {
		return crep.save(data);
	}
	
	public List<CarModel> getByOwn(int own){
		return crep.getCarInFromOwners(own);
	}
	public List<CarModel> getByAddr(String addr){
		return crep.getCarInFromAddress(addr);
	}
	public List<CarModel> getByName(String name){
		return crep.getCarFromName(name);
	}
	public List<CarModel> getBoth(int own, String type){
		return crep.getCarInFromOwnNCt(own, type);
	}
}