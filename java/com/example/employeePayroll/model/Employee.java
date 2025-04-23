package com.example.employeePayroll.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import com.example.employeePayroll.dto.EmployeePayrollDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    private String name;
    private long salary;
    private String gender;
    private String startDate;
    private String note;
    private String profilePic;
    private List<String>department;
    
    public Employee(int empId, EmployeePayrollDTO empPayrollDTO) {
    	this.employeeId =empId;
    	this.name = empPayrollDTO.name;
    	this.salary = empPayrollDTO.salary;
    	this.gender = empPayrollDTO.gender;
    	this.startDate = empPayrollDTO.startDate;
    	this.note = empPayrollDTO.note;
    	this.profilePic = empPayrollDTO.profilePic;
    	this.department = empPayrollDTO.deparment;
    }
    
}
