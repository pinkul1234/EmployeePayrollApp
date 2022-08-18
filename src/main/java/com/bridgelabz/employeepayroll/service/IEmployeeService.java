package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeeDto;
import com.bridgelabz.employeepayroll.model.EmployeeModel;
import com.bridgelabz.employeepayroll.util.Response;

import java.util.List;


public interface IEmployeeService {

    EmployeeModel addEmployee(EmployeeDto employeeDto, long departmentId);

    EmployeeModel updateemployee(long id, EmployeeDto employeeDto);

    List<EmployeeModel> getEmpData(String token);

    EmployeeModel deleteEmployee(long id);

    Response login(String email, String password);
}
