package com.example.employeePayroll.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.employeePayroll.dto.EmployeePayrollDTO;
import com.example.employeePayroll.model.Employee;
import com.example.employeePayroll.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {

    private final EmployeeRepository repo;

   
    public EmployeeService(EmployeeRepository empRep) {
        this.repo = empRep;
    }

    // Add new employee using DTO
    public Employee addEmployee(EmployeePayrollDTO dto) {
        Employee emp = mapToEntity(dto);
        log.debug("Saving new employee: {}", emp);
        return repo.save(emp);
    }

    // Get all employees
    public List<Employee> getAllEmployee() {
        log.debug("Fetching all employees");
        return repo.findAll();
    }

    // Get employee by ID
    public Employee getEmployeeById(int id) {
        log.debug("Fetching employee with ID: {}", id);
        return repo.findById(id).orElseThrow(() -> 
            new RuntimeException("Employee not found with ID: " + id));
    }

    // Update existing employee
    public Employee updateEmployee(int id, EmployeePayrollDTO dto) {
        Employee existingEmp = getEmployeeById(id);
        Employee updatedEmp = mapToEntity(dto);
        updatedEmp.setId(existingEmp.getId());
        log.debug("Updating employee ID {} with new data: {}", id, updatedEmp);
        return repo.save(updatedEmp);
    }

    // Delete employee by ID
    public void deleteEmployee(int id) {
        log.debug("Deleting employee with ID: {}", id);
        repo.deleteById(id);
    }

    // Helper method to map DTO to entity
    private Employee mapToEntity(EmployeePayrollDTO dto) {
        Employee emp = new Employee();
        emp.setName(dto.getName());
        emp.setSalary(dto.getSalary());
        emp.setGender(dto.getGender());
        emp.setStartDate(dto.getStartDate());
        emp.setNote(dto.getNote());
        emp.setProfilePic(dto.getProfilePic());
        emp.setDepartment(dto.getDepartment());
        return emp;
    }
}
