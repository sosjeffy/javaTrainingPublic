package com.example.demo.entity;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.interfaces.EntityToDtoConverter;

import jakarta.persistence.*;
@Entity
public class Employee implements EntityToDtoConverter<EmployeeDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String firstName;
    private String lastName;
    private int jobLevelId;
    private int departmentId;
    private String emailId;
    private int managerId;

    public Employee() {
    }

    public Employee(int employeeId, String firstName, String lastName, int jobLevelId, int departmentId, String emailId, int managerId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobLevelId = jobLevelId;
        this.departmentId = departmentId;
        this.emailId = emailId;
        this.managerId = managerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getJobLevelId() {
        return jobLevelId;
    }

    public void setJobLevelId(int jobLevelId) {
        this.jobLevelId = jobLevelId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Override
    public EmployeeDTO toDto() {
        return new EmployeeDTO(this.getEmployeeId(), this.getFirstName(), this.getLastName(), this.getJobLevelId(), this.getDepartmentId(), this.getEmailId(), this.getManagerId());
    }
}