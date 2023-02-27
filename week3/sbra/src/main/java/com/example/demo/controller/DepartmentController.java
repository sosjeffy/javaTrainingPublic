package com.example.demo.controller;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController is a combination of @Component (tells Spring this processes incoming requests) and @ResponseBody (return values
//from methods will be part of the body of a HTTP response and should be serialized to JSON
//@RequestMapping sets the base URI, forcing all requests to have to be made to /api/dept/*
@RestController
@RequestMapping( "/api/dept")
public class DepartmentController {
    DepartmentService departmentService;
//    Only needs @Autowired for constructor injection if we have multiple constructors
//    Constructor injection is recommended because it ensures that all required dependencies are available at runtime
    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public ResponseEntity<List<DepartmentDTO>> getDepartments(){
        return new ResponseEntity<>(departmentService.getDepartments(), HttpStatus.OK);
    }

    @PostMapping(value = "/add-dept")
    public ResponseEntity<DepartmentDTO> addDepartment(@Valid @RequestBody DepartmentDTO departmentDTO){
        departmentService.addDepartment(departmentDTO);
        return new ResponseEntity<>(departmentDTO, HttpStatus.CREATED);
    }
}
