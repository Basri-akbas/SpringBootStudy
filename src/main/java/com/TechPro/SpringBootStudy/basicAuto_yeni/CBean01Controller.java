package com.TechPro.SpringBootStudy.basicAuto_yeni;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CBean01Controller {

    private CBean01Service stdSrvc;//service layer' ulaşmak için obj create edildi
    public CBean01Controller(CBean01Service stdSrvc){
        this.stdSrvc = stdSrvc;
    }

    //bu method id ile ogrc returnn eden service methodu call edecek
    @GetMapping(path = "/selectStudentById/{id}")
    public CBean01 selectStudentById(@PathVariable Long id){

        return stdSrvc.selectStudentById(id);
    }
}
