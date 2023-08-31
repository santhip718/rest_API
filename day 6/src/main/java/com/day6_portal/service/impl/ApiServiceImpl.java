package com.day6_portal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.day6_portal.model.Child;
import com.day6_portal.repository.ChildRepo;
import com.day6_portal.service.ApiService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ApiServiceImpl implements ApiService {
    @Autowired
	private ChildRepo childRepo;
    
    @Override
    public boolean adduser(Child child) {
    	boolean userExists = childRepo.existsByAddress(child.getAddress());
		if(!userExists)
		{
			childRepo.save(child);
			return true;
		}else {
			
			return false;
		}
    }

    
	@Override
	public boolean updateuser(Long babyId,Child child) {
		Optional<Child>existingUserOptional =childRepo.findByBabyId(babyId);
		
		if(existingUserOptional.isPresent()) {
		Child userExists=existingUserOptional.get();
		userExists.setBabyFirstName(child.getBabyFirstName());
		userExists.setBabyLastName(child.getBabyLastName());
		userExists.setFatherName(child.getFatherName());
		userExists.setMotherName(child.getMotherName());
		userExists.setAddress(child.getAddress());
		childRepo.save(userExists);
		return true;
	}else {
		return false;
	}

}
	@Override
	public boolean deleteUser(Long babyId) {
		Optional<Child>existingUserOptional=childRepo.findByBabyId(babyId);
		if(existingUserOptional.isPresent()) {
			childRepo.deleteByBabyId(babyId);
			return true;
		}
		else {
			return false;
		}
	}


	@Override
	public Page<Child> getAllUser(PageRequest pageRequest) {
		return childRepo.findAll(pageRequest);
	}

	
}