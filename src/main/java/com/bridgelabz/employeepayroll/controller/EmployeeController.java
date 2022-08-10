package com.bridgelabz.employeepayroll.controller;

import com.bridgelabz.employeepayroll.dto.EmployeeDto;
import com.bridgelabz.employeepayroll.model.EmployeeModel;
import com.bridgelabz.employeepayroll.service.IEmployeeService;
import com.bridgelabz.employeepayroll.util.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayroll")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;

    @PostMapping("addemployee")
    public EmployeeModel addEmployee(@RequestBody EmployeeDto employeeDto){
    return employeeService.addEmployee(employeeDto);
    }

    @PostMapping("updateemployee/{id}")
    public EmployeeModel updateemployee(@RequestBody EmployeeDto employeeDto, @PathVariable long id ){
        return employeeService.updateemployee(id, employeeDto);
    }

    @GetMapping("getEmployeedata")
    public List<EmployeeModel> getallemployee(@RequestHeader String token)
    {
        return employeeService.getEmpData(token);
    }

    @DeleteMapping
    public EmployeeModel deleteemployee(@PathVariable long id){
        return employeeService.deleteEmployee(id);
    }

    @PostMapping("login")
    public Response login(@RequestParam String email, @RequestParam String password){
        return employeeService.login(email, password);
    }
}
