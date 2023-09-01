package com.day8_portal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.day8_portal.model.Bike;


public interface BikeRepo extends JpaRepository<Bike,Integer>{

	boolean existsByRegNumber(String regNumber);
	
	@Query("select b from Bike b")
	List<Bike>findAllQuery();

}