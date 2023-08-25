package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmpRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService {
	@Autowired
	EmpRepo em;
	
	public Employee saveDetails(Employee E) {
		return em.save(E); //post
	}
	
	public List<Employee> getDetails(){
		return em.findAll(); //get
	}
	public Optional<Employee> getById(int n){
		return em.findById(n); //getById
	}
	
	public Employee changeDetails(Employee E) {
		return em.saveAndFlush(E); //Update
	}
	public Employee updateEmployeeById(int id,Employee E) {
        Optional<Employee> optionalEmployee = em.findById(id);
        
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setBookName(E.getBookName());
            existingEmployee.setPrice(E.getPrice());
            existingEmployee.setQuantity(E.getQuantity());
            existingEmployee.setAutorName(E.getAutorName());
            return em.saveAndFlush(existingEmployee);
        } else {
            throw new EntityNotFoundException("Employee with ID " + id + " not found"); //updateById
        }
    }
	public void deleteDetails(Employee E) {
		em.delete(E); //delete
	}
	public void deleteDetailsById(int n) {
		em.deleteById(n); //deleteById
	}
	
	
}
