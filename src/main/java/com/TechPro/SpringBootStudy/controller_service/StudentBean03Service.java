package com.TechPro.SpringBootStudy.controller_service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StudentBean03Service {

   static List<StudentBean03> listOfStudent= Stream.of(new StudentBean03(101L,"ali veli","ali@gmail.com",LocalDate.of(1985,12,5))
                            ,new StudentBean03(102L,"basri ak","basri@gmail.com",LocalDate.of(1975,12,5))
                            ,new StudentBean03(103L,"zeki bey","zeki@gmail.com",LocalDate.of(1995,12,5))
                            ,new StudentBean03(104L,"ayse hanim","ayse@gmail.com",LocalDate.of(1999,12,5)))
                            .collect(Collectors.toList());




    public StudentBean03 getStudentById(Long id){

        if (listOfStudent.stream().filter(t->t.getId()==id).collect(Collectors.toList()).isEmpty()){
            return new StudentBean03();//p'siz cons return et
        }

        return listOfStudent.stream().filter(t->t.getId()==id).findFirst().get();
    }

    //tum listi return eden method
    public List<StudentBean03> getAllStudent(){
        return listOfStudent;
    }
















}
