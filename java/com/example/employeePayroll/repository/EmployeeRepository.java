package com.example.employeePayroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeePayroll.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
