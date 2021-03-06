package com.TechPro.SpringBootStudy.basic_authentication;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name="students")
public class StudentBean05 {
    @Id
    private Long id;

    private String name;

    private String email;

    private LocalDate dob;

    private Integer yas;

    private String errMsg;

    public StudentBean05(){
        this.errMsg="Agam senin ogrenci arazi yokkkkkkkkkkk :-(";
    }

    public StudentBean05(Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.errMsg="Devamke agam...........";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {

        this.dob = dob;
    }

    public Integer getYas() {
        if(this.dob==null){
            return null;
        }
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setYas(Integer yas) {
        this.yas = yas;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "StudentBean05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", yas=" + yas +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
