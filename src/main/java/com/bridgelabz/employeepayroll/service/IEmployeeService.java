package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeeDto;
import com.bridgelabz.employeepayroll.model.EmployeeModel;
import com.bridgelabz.employeepayroll.util.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmployeeService {

    EmployeeModel addEmployee(EmployeeDto employeeDto);

    EmployeeModel updateemployee(long id, EmployeeDto employeeDto);

    List<EmployeeModel> getEmpData(String token);

    EmployeeModel deleteEmployee(long id);

    Response login(String email, String password);
}
