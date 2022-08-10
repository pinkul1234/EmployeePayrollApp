package com.bridgelabz.employeepayroll.repository;

import com.bridgelabz.employeepayroll.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {

}
