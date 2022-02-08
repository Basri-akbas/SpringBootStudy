package com.TechPro.SpringBootStudy.controller_service_repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentBean04Controller {
    private StudentBean04Service stdSrvc;//service layer' ulaşmak için obj create edildi
    @Autowired
    public StudentBean04Controller(StudentBean04Service stdSrvc){
        this.stdSrvc = stdSrvc;
    }

    //bu method id ile ogrc returnn eden service methodu call edecek
    @GetMapping(path = "/@RestController{id}")
    public StudentBean04 selectStudentById(@PathVariable Long id){

        return stdSrvc.selectStudentById(id);
    }


}
