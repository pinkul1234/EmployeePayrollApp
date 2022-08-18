package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.DepartmentDto;
import com.bridgelabz.employeepayroll.model.EmployeeDepartment;

public interface IDepartmentService {
    EmployeeDepartment addDepartment(DepartmentDto departmentDto);
}
