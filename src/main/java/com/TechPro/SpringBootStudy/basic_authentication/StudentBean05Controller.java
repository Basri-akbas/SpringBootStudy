package com.TechPro.SpringBootStudy.basic_authentication;

import com.TechPro.SpringBootStudy.controller_service_repository.StudentBean04;
import com.TechPro.SpringBootStudy.controller_service_repository.StudentBean04Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentBean05Controller {
    private StudentBean05Service stdSrvc;//service layer' ulaşmak için obj create edildi
    public StudentBean05Controller(StudentBean05Service stdSrvc){
        this.stdSrvc=stdSrvc;
    }

    //bu method id ile ogrc returnn eden service methodu call edecek
    @GetMapping(path = "/selectStudentById/{id}")
    public StudentBean05 selectStudentById(@PathVariable Long id){

        return stdSrvc.selectStudentById(id);
    }


}