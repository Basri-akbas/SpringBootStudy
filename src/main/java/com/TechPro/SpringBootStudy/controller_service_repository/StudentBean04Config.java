package com.TechPro.SpringBootStudy.controller_service_repository;

import com.TechPro.SpringBootStudy.controller_service.StudentBean03;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
//Bu class'da data create edip DB'deki tabloya datalar gönderilecek:SQL insert komutu ile de yapılabilir
public class StudentBean04Config {
    @Bean//obj return edilen mwethodlar @bean annotation kullanılır..İnterview :@Bean sadece method level de kullanılır
        //veriable class ve cons level de kullanılmaz
    CommandLineRunner clr1(StudentBean04Repository studentRepo){

        return args -> studentRepo.saveAll(Stream.of(new StudentBean04(110L,"basri akbas","basri@gmail.com",LocalDate.of(1975,12,5)),
                                    new StudentBean04(111L,"seima elmazi","se@gamil.com",LocalDate.of(1985,12,5)),
                new StudentBean04(112L,"selim akbas","sa@gamil.com",LocalDate.of(2015,12,5)),
                new StudentBean04(119L,"ali veli","av@gamil.com",LocalDate.of(1995,12,5))).collect(Collectors.toList()));
    }
}
