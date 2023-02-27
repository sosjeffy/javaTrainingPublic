package com.example.demo.service;

import com.example.demo.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
    public DepartmentDTO addDepartment(DepartmentDTO department);

    List<DepartmentDTO> getDepartments();
}
