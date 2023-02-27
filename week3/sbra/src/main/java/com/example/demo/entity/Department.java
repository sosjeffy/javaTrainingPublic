package com.example.demo.entity;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.interfaces.EntityToDtoConverter;

import jakarta.persistence.*;
@Entity
public class Department implements EntityToDtoConverter<DepartmentDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;
    private String departmentName;
    private int departmentNumber;

    public Department(int departmentId, String departmentName, int departmentNumber) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentNumber = departmentNumber;
    }

    public Department() {
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
    public DepartmentDTO toDto() {
        return new DepartmentDTO(this.getDepartmentId(), this.getDepartmentName(), this.getDepartmentNumber());
    }
}