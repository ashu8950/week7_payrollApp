package com.example.employeePayroll.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Data
@AllArgsConstructor
@NoArgsConstructor
public @ToString class EmployeePayrollDTO {

    @Pattern(regexp = "^[A-Z]{1}[A-Za-z\\s]{2,}$", message = "Employee name invalid")
    public String name;

    @Min(value = 500, message = "Min wage should be more than 500")
    public long salary;

    @Pattern(regexp = "(?i)male|female", message = "Gender must be 'male' or 'female'")
    public String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "Start date should not be null")
    @PastOrPresent(message = "Start date should be past or present")
    public LocalDate startDate;

    @NotBlank(message = "Note cannot be blank")
    public String note;

    @NotBlank(message = "Profile pic cannot be empty")
    public String profilePic;

    @NotNull(message = "Department should not be empty")
    public List<String> department;
}
