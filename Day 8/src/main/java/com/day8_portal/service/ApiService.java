package com.day8_portal.service;
import java.util.List;
import com.day8_portal.model.Bike;

public interface ApiService {
	public boolean addBike(Bike bike);
	List<Bike> findAllQuery();
}