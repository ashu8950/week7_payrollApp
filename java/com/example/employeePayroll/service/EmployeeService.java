package com.example.employeePayroll.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employeePayroll.model.Employee;
import com.example.employeePayroll.repository.EmployeeRepository;


@Service
public class EmployeeService {
	
	
	private EmployeeRepository repo;
	
	
	public EmployeeService(EmployeeRepository empRep) {
		this.repo = empRep;
	}
	
	//add Employee
	public Employee addEmployee(Employee emp) {
		return repo.save(emp);
	}
	
	//get all employee
	public List<Employee>getAllEmployee(){
		return repo.findAll();
	}
	
	//get employee by id
	public Employee getEmployeeById(Long id) {
		return repo.findById(id).orElseThrow();
	}

	public Employee updateEmployee(Long id, Employee updatedEmp) {
		// TODO Auto-generated method stub
		Employee emp = getEmployeeById(id);
		updatedEmp.setId(emp.getId());
		return repo.save(updatedEmp);
	}

	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
}
