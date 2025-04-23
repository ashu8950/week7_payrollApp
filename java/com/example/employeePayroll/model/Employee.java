package com.example.employeePayroll.model;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;

    @ElementCollection
    @CollectionTable(
        name = "employee_departments",
        joinColumns = @JoinColumn(name = "employee_id")
    )
    @Column(name = "department")
    private List<String> department;

    public Employee(int empId, EmployeePayrollDTO empPayrollDTO) {
        this.id = empId;
        this.name = empPayrollDTO.name;
        this.salary = empPayrollDTO.salary;
        this.gender = empPayrollDTO.gender;
        this.startDate = empPayrollDTO.startDate;
        this.note = empPayrollDTO.note;
        this.profilePic = empPayrollDTO.profilePic;
        this.department = empPayrollDTO.department;
    }
}
