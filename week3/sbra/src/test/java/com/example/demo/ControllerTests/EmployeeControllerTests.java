package com.example.demo.ControllerTests;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class EmployeeControllerTests {
    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeService employeeService = new EmployeeServiceImpl();

    @Test
    public void getAllEmployeesWhenNoEmployeesExist() {
        Mockito.when(employeeRepository.findAll()).thenReturn(new ArrayList<>());
        Assertions.assertEquals(0, employeeService.getEmployees().size());
    }

    @Test
    public void addEmployee() {
        EmployeeDTO emp = new EmployeeDTO();
        Mockito.when(employeeRepository.save(emp.toEntity())).thenReturn(emp.toEntity());
        Assertions.assertEquals(emp, employeeService.addEmployee(emp));
    }

}
