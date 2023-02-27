package com.example.demo.dto;

import com.example.demo.entity.Employee;
import com.example.demo.interfaces.DtoToEntityConverter;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class EmployeeDTO implements DtoToEntityConverter<Employee> {
    private int employeeId;
    private String firstName;
    private String lastName;
    @Min(value = 1, message = "INVALID JOB ID: Must be >= 1")
    @Max(value = 10, message = "INVALID JOB ID: Must be <= 10")
    private int jobLevelId;
    private int departmentId;
    private String emailId;
    private int managerId;

    public EmployeeDTO() {
        super();
    }

    public EmployeeDTO(int employeeId, String firstName, String lastName, int jobLevelId, int departmentId, String emailId, int managerId) {
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
    public Employee toEntity() {
        return new Employee(this.getEmployeeId(),
                this.getFirstName(),
                this.getLastName(),
                this.getJobLevelId(),
                this.getDepartmentId(),
                this.getEmailId(),
                this.getManagerId());
    }
}