package com.example.demo.service;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("departmentService")
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO addDepartment(DepartmentDTO department) {
        departmentRepository.save(department.toEntity());
        return department;
    }

    @Override
    public List<DepartmentDTO> getDepartments() {
        List<DepartmentDTO> departments = new ArrayList<>();
        departmentRepository.findAll().forEach(dept -> departments.add(dept.toDto()));
        return departments;
    }
}
