package com.spbgti.dispatcherapp.repository;

import com.spbgti.dispatcherapp.entity.Chair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChairRepository extends JpaRepository<Chair, Long>{
    @Query("select b from Chair b where b.name = :name")
    Chair findByName(@Param("name") String name);
}
