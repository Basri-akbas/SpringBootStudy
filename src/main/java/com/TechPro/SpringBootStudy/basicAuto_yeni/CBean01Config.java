package com.TechPro.SpringBootStudy.basicAuto_yeni;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class CBean01Config {

    @Bean
    CommandLineRunner clr1(CBean01Repository studentRepo){


        return args-> studentRepo.saveAll(Stream.of(
                new CBean01(110L,"lutfullah bey","le@cimeyıl.com", LocalDate.of(1992,4,23)),
                new CBean01(111L,"mehmet bey","mhtr@cimeyıl.com", LocalDate.of(1990,6,3)),
                new CBean01(112L,"suleyman bey","slmn@cimeyıl.com", LocalDate.of(2000,10,12)),
                new CBean01(113L,"gökhan bey","gkhn@cimeyıl.com", LocalDate.of(1996,9,7)),
                new CBean01(133L,"islam bey","selam@cimeyıl.com", LocalDate.of(1996,9,7))

        ).collect(Collectors.toList()));

    }




}
