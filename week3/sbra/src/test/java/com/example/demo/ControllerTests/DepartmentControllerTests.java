package com.example.demo.ControllerTests;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.DepartmentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class DepartmentControllerTests {
    @Mock
    DepartmentRepository departmentRepository;

    @InjectMocks
    DepartmentService departmentService = new DepartmentServiceImpl();

    @Test
    public void getAllDepartmentsWhenNoDepartmentsExist() {
        Mockito.when(departmentRepository.findAll()).thenReturn(new ArrayList<>());
        Assertions.assertEquals(0, departmentService.getDepartments().size());
    }

    @Test
    public void addDepartment() {
        DepartmentDTO dept = new DepartmentDTO();
        Mockito.when(departmentRepository.save(dept.toEntity())).thenReturn(dept.toEntity());
        Assertions.assertEquals(dept, departmentService.addDepartment(dept));
    }
}

