package com.example.demo.dto;

import com.example.demo.entity.Department;
import com.example.demo.interfaces.DtoToEntityConverter;
import jakarta.validation.constraints.NotBlank;

public class DepartmentDTO implements DtoToEntityConverter<Department> {
    private int departmentId;
    @NotBlank(message = "INVALID DEPARTMENT NAME: Need to specify department name")
    private String departmentName;
    private int departmentNumber;

    public DepartmentDTO() {
        super();
    }

    public DepartmentDTO(int departmentId, String departmentName, int departmentNumber) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentNumber = departmentNumber;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentNumber=" + departmentNumber +
                '}';
    }

    @Override
    public Department toEntity() {
        return new Department(this.getDepartmentId(),
                this.getDepartmentName(),
                this.getDepartmentNumber());
    }
}