package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    DepartmentRepository departmentRepository;


    @Override
    public void saveDepartment(Department department) {
//        if(!departmentRepository.existsById(department.getDepartmentId())){
             departmentRepository.save(department);
//        }else {
//           throw new RuntimeException("Department is all ready exist by ID"+department.getDepartmentId());
//        }
    }


    @Override
    public List<Department> fetchDepartment() {
        return departmentRepository.findAll();
    }


    @Override
    public Department fetchDepartmentById(Long departmetId) {
        return departmentRepository.findById(departmetId).get();
    }


    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }


    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department temp = departmentRepository.findById(departmentId).get();
        temp.setDepartmentName(department.getDepartmentName());
        return departmentRepository.save(temp);
    }





}
