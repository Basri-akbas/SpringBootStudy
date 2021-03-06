package com.TechPro.SpringBootStudy.controller_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentBean03Controller {

    private StudentBean03Service std;
    @Autowired
    public StudentBean03Controller(StudentBean03Service  std){
        this.std=std;
    }

    @GetMapping(path="/getStudentById")
    public StudentBean03 getStudentIdIle(){
        return  std.getStudentById(104L);
    }

    @GetMapping(path="/getStudentById1/{id}")
    public StudentBean03 getStudentId(@PathVariable Long id){
        return  std.getStudentById(id);
    }

    @GetMapping(path="/getStudentList")
    public List<StudentBean03> getStudentHepsi(){
        return std.getAllStudent();
    }

}
