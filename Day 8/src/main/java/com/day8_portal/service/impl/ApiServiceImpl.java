package com.day8_portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day8_portal.model.Bike;
import com.day8_portal.repository.BikeRepo;
import com.day8_portal.service.ApiService;

@Service
public class ApiServiceImpl implements ApiService {
    @Autowired
	private BikeRepo bikeRepo;
    
    @Override
    public boolean addBike(Bike bike) {
    	boolean userExists = bikeRepo.existsByRegNumber(bike.getRegNumber());
		if(!userExists)
		{
			bikeRepo.save(bike);
			return true;
		}else {
			
			return false;
		}
    }


	@Override
	public List<Bike> findAllQuery() {
		return bikeRepo.findAllQuery();
	}

	
}