package com.example.employeePayroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeePayroll.model.Employee;
import com.example.employeePayroll.service.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	//add employee
	@PostMapping
	public Employee addEmployee(@RequestBody Employee emp) {
		return service.addEmployee(emp);
	}
	
	//getAllEmployee
	@GetMapping
	public java.util.List<Employee>getAllEmployee(){
		return service.getAllEmployee();
	}
	
	//get by id
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable Long id) {
		return service.getEmployeeById(id);
	}
	
	//update employee data
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Long id ,@RequestBody Employee emp) {
		return service.updateEmployee(id,emp);
	}
	
	//delete employee data
	@DeleteMapping("{id}")
	public void deleteEmployee(@PathVariable Long id) {
		service.deleteEmployee(id);
	}
	
	
	
}
