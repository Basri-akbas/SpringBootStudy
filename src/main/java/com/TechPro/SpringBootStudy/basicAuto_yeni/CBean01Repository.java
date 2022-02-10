package com.TechPro.SpringBootStudy.basicAuto_yeni;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CBean01Repository extends JpaRepository<CBean01,Long> {

    Optional<CBean01> findCBean01ByEmail(String email);
}
