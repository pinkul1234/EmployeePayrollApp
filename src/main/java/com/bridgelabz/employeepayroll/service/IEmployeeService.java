package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeeDto;
import com.bridgelabz.employeepayroll.model.EmployeeModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmployeeService {

    EmployeeModel addEmployee(EmployeeDto employeeDto);

    EmployeeModel updateemployee(long id, EmployeeDto employeeDto);

    List<EmployeeModel> getEmpData();

    EmployeeModel deleteEmployee(long id);
}
