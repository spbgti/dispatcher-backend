package com.spbgti.dispatcherapp.Repository;

import com.spbgti.dispatcherapp.Entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Gilbord on 29.07.2017.
 */
public interface SeniorRepository extends JpaRepository<Candidate, Long>{
    Candidate findByName(@Param("name") String name);
}
