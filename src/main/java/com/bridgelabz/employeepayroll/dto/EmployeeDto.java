package com.bridgelabz.employeepayroll.dto;

import com.bridgelabz.employeepayroll.model.EmployeeDepartment;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Data
public class EmployeeDto {
    @Pattern(regexp = "[A-Z]{1}", message = "Enter Valid firstname")
    private String firstName;
    private String lastName;
    private String companyName;
    @Min(value = 11)
    private long salary;
    private String emailId;
    private String password;


}