package com.TechPro.SpringBootStudy.basic_authentication;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum ApplicationUserRoles {//Enum:app sabit  datalarin saklandigi yapidir.

    STUDENT(Sets.newHashSet(ApplicationUserPermission.STUDENT_READ)), ADMIN(Sets.newHashSet(ApplicationUserPermission.STUDENT_READ,ApplicationUserPermission.STUDENT_WRITE));

    private final Set<ApplicationUserPermission> permission;

    ApplicationUserRoles(Set<ApplicationUserPermission> permission) {
        this.permission = permission;
    }

    public Set<ApplicationUserPermission> izinleriGetirenMethod() {//permissions obj data field(STUDENT_READ,STUDENT_WRITE) okumak için get
        return permission;
    }

    public Set<SimpleGrantedAuthority> izinOnayla() {
        Set<SimpleGrantedAuthority> onaylananIzinler= izinleriGetirenMethod().
                stream().
                map(t-> new SimpleGrantedAuthority(t.getPermission())).
                collect(Collectors.toSet());
        onaylananIzinler.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return onaylananIzinler;
    }





}
