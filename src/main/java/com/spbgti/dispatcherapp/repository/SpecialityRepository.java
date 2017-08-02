package com.spbgti.dispatcherapp.repository;


import com.spbgti.dispatcherapp.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface SpecialityRepository extends JpaRepository<Speciality, Long>{
    Speciality findByName(@Param("name") String name );
}
