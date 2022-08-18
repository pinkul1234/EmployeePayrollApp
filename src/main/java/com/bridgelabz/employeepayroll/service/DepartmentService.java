package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.DepartmentDto;
import com.bridgelabz.employeepayroll.model.EmployeeDepartment;
import com.bridgelabz.employeepayroll.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public EmployeeDepartment addDepartment(DepartmentDto departmentDto) {
        EmployeeDepartment employeeDepartment = new EmployeeDepartment();
        employeeDepartment.setDepartmentName(departmentDto.getDepartmentName());
        employeeDepartment.setDepartmentDescription(departmentDto.getDepartmentDesc());
        employeeDepartment.setCreatedTimeStamp(LocalDateTime.now());
        employeeDepartment.setUpdatedTimeStamp(LocalDateTime.now());
        departmentRepository.save(employeeDepartment);
        return employeeDepartment;
    }
}
