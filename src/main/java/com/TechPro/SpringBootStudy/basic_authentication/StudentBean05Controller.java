package com.TechPro.SpringBootStudy.basic_authentication;

import com.TechPro.SpringBootStudy.controller_service_repository.StudentBean04;
import com.TechPro.SpringBootStudy.controller_service_repository.StudentBean04Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(path = "/selectAllStudents")
    public List<StudentBean05> selectAllStudents() {
        return stdSrvc.selectAllStudents();
    }

    @PutMapping(path = "/updateFullyStudentById/{id}")
    public StudentBean05 updatefulltStudentIdile(@PathVariable Long id,@RequestBody StudentBean05 newStd){


        return stdSrvc.updateFullyStudentById(id,newStd);
    }

}
