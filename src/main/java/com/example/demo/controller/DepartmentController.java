package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import com.example.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;


    @PostMapping
    public ResponseEntity saveDepartment(@RequestBody Department department){
        departmentService.saveDepartment(department);
        return new ResponseEntity(new StandardResponse(200,"Success",null), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity fetchDepartment(){
       List <Department> allDepartment = departmentService.fetchDepartment();
        return new ResponseEntity(new StandardResponse(200,"Success",allDepartment), HttpStatus.OK);
    }

    @GetMapping(path = {"/{departmentId}"})
    public ResponseEntity fetchDepartmentById(@PathVariable Long departmentId){
        Department department= departmentService.fetchDepartmentById(departmentId);
        return new ResponseEntity(new StandardResponse(200,"Success",department),HttpStatus.OK);
    }

    @DeleteMapping(params = {"departmentId"})
    public ResponseEntity deleteDepartmentById(@RequestParam Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return new ResponseEntity(new StandardResponse(200,"Success",null),HttpStatus.OK);
    }

    @PutMapping(path={"/{departmentId}"})
    public ResponseEntity updateDepartment(@PathVariable Long departmentId ,@RequestBody Department department){
         departmentService.updateDepartment(departmentId,department);
        return new ResponseEntity(new StandardResponse(200,"Success",null),HttpStatus.OK);
    }
}
