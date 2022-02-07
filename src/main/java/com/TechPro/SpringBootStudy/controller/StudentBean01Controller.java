package com.TechPro.SpringBootStudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//@Controller//SpringBoot bu class'ı control layer  olarak tanımlar
@RestController
//Controller annotasyonu Dispatcher servisinden mutlak üzere bir View alınması zorunlu ilen RestController buna gereksinim duymaz.
// Herhangi bir Controller annotasyonu ile oluşturulmuş bir Controller'a ise sınıf bazında veya fonksiyon bazında ResponseBody
// annotastonu eklenerek Rest Response sağlanır ve herhangi bir 404 hatası alınmaz.
public class StudentBean01Controller {
    //@RequestMapping(method= RequestMethod.GET, path="/getRequest")//sadece get işlemlerinde  ve bu adresten geldiyese bu metoduu çalıştır.
    //@ResponseBody//Method'un return ettigi datayı gösterir--> tavsiye edilmez
    //public String getMethod1() {

    //    return "Get Request method calıştı";
    //}
    @GetMapping(path = "/getRequest")//--> Get Request'leri getMethod2() ile mapping yapıp path'deki url  calısır return edilen data gösterilir
    public String getMethod2() {

        return "agam bu method daha basarili";
    }

    //Tight coupling tercih edilmez
    @GetMapping(path = "/getObject")
    public StudentBean01  getObjectTight(){

        return new StudentBean01("Islam",33,"ig202233");
    }

    //Loose coupling
    @Autowired  //StudentBean01 data type de IOC conteiner e default obj create eder
    StudentBean01  s;   //StudentBean01 s =new StudentBean01();==>tight coupling new StudentBean01()-->@Compenent ,"="-->@Autowired
    @GetMapping(path = "/getObjectLoose")
    public StudentBean01  getObjectLoose(){
        s.setAge(41);
        s.setId("gh200241");
        s.setName("Gokhan");
        return  s;
    }

    //Tight coupling...Parametreli url--> url ile girilen parametreyi return edilen datada atanmsı
    @GetMapping(path = "/getObjectParametreli/{school}")
    public StudentBean01 getObjectParametreli(@PathVariable String school) {

        return new StudentBean01("cengiz erdem", 44, String.format("ce1978%s", school));

    }

    //tight coupling..List return
    @GetMapping(path = "/getObjectList")
    public List<StudentBean01> getObjectList() {

        return Stream.of(new StudentBean01("gökhan bey", 33, "abc"),
                (new StudentBean01("islam bey", 43, "xyz")),
                (new StudentBean01("hatice  hanım", 27, "***"))).collect(Collectors.toList()); //java 8 de böyle ama java 11 de List.of

    }

    //Loose coupling...
    @Autowired   //Not:@Autowired-->Loose coupling de her variable icin kullanilmali
    StudentBean02 t;
    @GetMapping(path = "/getStudy")
    public String getStudy01(){
        return t.study();
    }


    @Autowired
     @Qualifier  (value="studentBean02")     //@Qualifier-->@Autowired     ile tanimlanan obj cretae edilecek data type ni tanimlar.Tanimlanacak data type annaotation a parametre olur
                //bu interfaceden oluşan deklarasyona IOC’deki studentBean01 veya studentBean02 adındaki bekleyen variable’lardan hangisini atayacağına karar veriyoruz qualifier ile
    StudentInterface u;
    @GetMapping(path = "/getStudy1")
    public String getStudy02(){
        return u.study();
    }











}
