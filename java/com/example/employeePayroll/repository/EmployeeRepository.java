package com.example.employeePayroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.employeePayroll.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	@Query("SELECT e FROM Employee e JOIN e.department d WHERE d = :deptName")
    List<Employee> findByDepartmentName(@Param("deptName") String deptName);
}
