package com.example.employeePayroll.controller;

import com.example.employeePayroll.dto.EmployeePayrollDTO;
import com.example.employeePayroll.model.Employee;
import com.example.employeePayroll.service.EmployeeService;

import jakarta.validation.Valid;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // Create Employee
    @PostMapping
    public Employee createEmployee(@Valid @RequestBody EmployeePayrollDTO employeeDto) {
        log.info("Creating new employee: {}", employeeDto);
        return service.addEmployee(employeeDto);
    }

    // Get All Employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees");
        return service.getAllEmployee();
    }

    // Get Employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        log.info("Fetching employee with ID: {}", id);
        return service.getEmployeeById(id);
    }

    // Update Employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeePayrollDTO employeeDto) {
        log.info("Updating employee with ID: {} | Data: {}", id, employeeDto);
        return service.updateEmployee(id, employeeDto);
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        log.info("Deleting employee with ID: {}", id);
        service.deleteEmployee(id);
    }
    //getting department by name
    @GetMapping("/department/{name}")
    public List<Employee> getEmployeesByDepartment(@PathVariable String name) {
        return service.getEmployeesByDepartment(name);
    }

}