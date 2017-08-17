package com.spbgti.dispatcherapp.Repository;

import com.spbgti.dispatcherapp.Entity.Chair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ChairRepository extends JpaRepository<Chair, Long>{
    Chair findByName(@Param("name") String name);
}
