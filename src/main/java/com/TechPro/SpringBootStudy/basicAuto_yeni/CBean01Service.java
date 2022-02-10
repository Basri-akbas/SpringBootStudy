package com.TechPro.SpringBootStudy.basicAuto_yeni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CBean01Service {

    private CBean01Repository studentRepo;//Repository layer'a ulaşmak için data type'nan obj create edildi.
    //obj degerini cons'dan alacak
    @Autowired
    public CBean01Service(CBean01Repository studentRepo){
        this.studentRepo = studentRepo;
    }
    //Bu method id ile ögrc return edecek
    public CBean01 selectStudentById(Long id){
        // return studentRepo.findById(id).get();--> olmayan id hata verir code kırlrı bununiçin kontrol if çalışmalı
        if (studentRepo.findById(id).isPresent()){

            return studentRepo.findById(id).get();
        }
        return new CBean01();//isteen id yoksa bos cons run edilecek
    }




}
