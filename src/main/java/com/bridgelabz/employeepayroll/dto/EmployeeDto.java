package com.bridgelabz.employeepayroll.dto;

import lombok.*;

@Data
public class EmployeeDto {
    private String firstName;
    private String lastName;
    private String companyName;
    private long salary;
    private String department;
    private String emailId;
    private String password;

}