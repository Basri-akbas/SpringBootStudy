package com.TechPro.SpringBootStudy.basic_authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//Tanımlı oldg class'da  @PreAuthorize-->annato active etmek için kullanıldıgınn MUTLAKA KULLANILMALI
//@PreAuthorize kullanılmazsa gerek yok
public class AppicationSecurityconfig extends WebSecurityConfigurerAdapter {

    private final PasswordConfig passEncode;//final  obj bir deger almalı bu degeri alacagı cons create edilmeli
    @Autowired
    public AppicationSecurityconfig(PasswordConfig passEncode) {//PasswordConfig class'dan create edilen  obj deger atayan cons.
        this.passEncode = passEncode;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                csrf().disable().//ey springboot put delete post patch method calıştır. sorumluluk benim..Bu methodların block'un(default) kaldır
                authorizeRequests().//her request için//Requestler için yetki sorgula (get put patch delete post)
                antMatchers("/", "index", "/css/*", "/js/*").permitAll(). //antMatchers() method parametresindeki url'lere izin(username pass sorgusu yapma) ver
                // antMatchers("/**").hasRole(ApplicationUserRoles.ADMIN.name()).//ROLE BASED AUTH:home page'den sonraki tum sayfalara SADECE admin name sahip user role  kullanabilir.
                // ROLE BASED AUTH. sadece anlamında bir komutur
                //Role auth permission aut ezer. role oldg permission calışmaz Sert bir securty barıyeridr. gerekli oldg yerde kullanılmalı ama permission auth daha esnek oldg daha cok kullanılır
                        anyRequest().//her request için
                authenticated().//kullanıcı sorgula
                and().//neye göre
                httpBasic();//httpBasic 'e göre
        //her request'te APP username ve pass(security) control edilmeli logout yapmaya gerek kalmayacak
        //Benim istedigim kişiler apt girdikten sonra herkes yetki sahibi olsun
    }


    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        // UserDetails student = User.builder().username("haluk").password("1453").roles("sefil AGA","javaya fısıldayan adam").build();
        UserDetails student = User.
                builder().
                username("haluk").password(passEncode.passSifrele().encode("1453")).
                //roles("sefil AGA","javaya fısıldayan adam").
                authorities(ApplicationUserRoles.STUDENT.izinOnayla()).
                build();
        // UserDetails hanimaga = User.builder().username("ipek").password("1979").roles("HANIM AGA hukumat gadınnn").build();
        UserDetails hanimaga = User.builder().username("ipek").password(passEncode.passSifrele().encode("1979")).roles("HANIM AGA hukumat gadınnn").build();
        UserDetails admin = User.
                builder().
                username("admin").password(passEncode.passSifrele().encode("nimda")).
                //roles("ADMIN").
                authorities(ApplicationUserRoles.ADMIN.izinOnayla()).
                build();//convension tanım
        // UserDetails admin = User.builder().username("admin").password("nimda").roles("ADMIN").build();//convension tanım
        // return student;//returm uyumsuzluk hatası
        return new InMemoryUserDetailsManager(student,admin,hanimaga);
    }
}
