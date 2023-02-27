package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// @Service annotation denotes this as a service. Spring would be able to scan for an instance of this class for us to access later
// @Transactional will denote all methods as transactions, which means that changes will need to be rolled back if something went wrong
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> getEmployees() {
        List<EmployeeDTO> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(emp -> employees.add(emp.toDto()));
        return employees;
    }

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employee) {
        employeeRepository.save(employee.toEntity());
        return employee;
    }
}
