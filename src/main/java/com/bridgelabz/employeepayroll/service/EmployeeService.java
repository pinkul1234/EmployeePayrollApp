package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeeDto;
import com.bridgelabz.employeepayroll.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayroll.model.EmployeeModel;
import com.bridgelabz.employeepayroll.repository.EmployeeRepository;
import com.bridgelabz.employeepayroll.util.Response;
import com.bridgelabz.employeepayroll.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    TokenUtil tokenUtil;
    @Override
    public EmployeeModel addEmployee(EmployeeDto employeeDto) {
        EmployeeModel employeeModel = new EmployeeModel(employeeDto);
        employeeModel.setRegisteredData(LocalDateTime.now());
        employeeRepository.save(employeeModel);
        return employeeModel;
    }
    @Override
    public EmployeeModel updateemployee(long id, EmployeeDto employeeDto) {

        Optional<EmployeeModel> isEmployeePresent = employeeRepository.findById(id);
        if(isEmployeePresent.isPresent()){
            isEmployeePresent.get().setFirstName(employeeDto.getFirstName());
            isEmployeePresent.get().setLastName(employeeDto.getLastName());
            isEmployeePresent.get().setCompanyName(employeeDto.getCompanyName());
            isEmployeePresent.get().setDepartment(employeeDto.getDepartment());
            isEmployeePresent.get().setSalary(employeeDto.getSalary());
            isEmployeePresent.get().setUpdatedDate(LocalDateTime.now());

            employeeRepository.save(isEmployeePresent.get());
            return isEmployeePresent.get();
        }
        throw new EmployeeNotFoundException(488, "Employee Not Present!!!");
    }
    @Override
    public List<EmployeeModel> getEmpData(String token) {
        long empId = tokenUtil.decodeToken(token);
        Optional<EmployeeModel> isEmployeeePresent = employeeRepository.findById(empId);
        if(isEmployeeePresent.isPresent()) {
            List<EmployeeModel> getallemployee = employeeRepository.findAll();
            if (getallemployee.size() > 0)
                return getallemployee;

            else
                throw new EmployeeNotFoundException(400, "No Data Present");
        }
        throw new EmployeeNotFoundException(400, "Employee Not Found");
    }
    @Override
    public EmployeeModel deleteEmployee(long id) {
        Optional<EmployeeModel> isEmployeePresent = employeeRepository.findById(id);
        if(isEmployeePresent.isPresent()){
            employeeRepository.delete(isEmployeePresent.get());
            return isEmployeePresent.get();
        }
        throw new EmployeeNotFoundException(400, "Employee Not Present");
    }

    @Override
    public Response login(String email, String password) {
        Optional<EmployeeModel> isEmailPresent = employeeRepository.findById(email);
        if(isEmailPresent.isPresent()) {
            if (isEmailPresent.get().getPassword().equals(password)) {
                String token = tokenUtil.createToken(isEmailPresent.get().getEmployeeId());
                return new Response("login successful", 200, token);
            }
            throw new EmployeeNotFoundException(400, "Invalid Credentials");
        }
        throw new EmployeeNotFoundException(400, "Employee Not Found");
    }
}
