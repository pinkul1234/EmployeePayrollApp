package com.bridgelabz.employeepayroll.controller;

import com.bridgelabz.employeepayroll.dto.DepartmentDto;
import com.bridgelabz.employeepayroll.model.EmployeeDepartment;
import com.bridgelabz.employeepayroll.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    IDepartmentService departmentService;
    @PostMapping
    public EmployeeDepartment addDepartment(@RequestBody DepartmentDto departmentDto){
        return departmentService.addDepartment(departmentDto);

    }

}
