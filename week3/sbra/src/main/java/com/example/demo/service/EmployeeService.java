package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeDTO> getEmployees();

    EmployeeDTO addEmployee(EmployeeDTO employee);
}
