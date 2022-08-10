package com.bridgelabz.employeepayroll.model;

import com.bridgelabz.employeepayroll.dto.EmployeeDto;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Employee")
@Data
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String companyName;
    private long salary;
    private String department;
    private LocalDateTime registeredData;
    private LocalDateTime updatedDate;

    public EmployeeModel(EmployeeDto employeeDto){
        this.firstName = employeeDto.getFirstName();
        this.lastName = employeeDto.getLastName();
        this.companyName = employeeDto.getCompanyName();
        this.salary = employeeDto.getSalary();
        this.department = employeeDto.getDepartment();
    }

    public EmployeeModel() {

    }
}
