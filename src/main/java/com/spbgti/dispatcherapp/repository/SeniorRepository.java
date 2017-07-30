package com.spbgti.dispatcherapp.repository;

import com.spbgti.dispatcherapp.entity.Senior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Gilbord on 29.07.2017.
 */
public interface SeniorRepository extends JpaRepository<Senior, Long>{
    Senior findByName(@Param("name") String name);
}
