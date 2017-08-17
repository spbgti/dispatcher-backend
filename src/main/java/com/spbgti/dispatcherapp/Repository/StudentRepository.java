package com.spbgti.dispatcherapp.Repository;

import com.spbgti.dispatcherapp.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Gilbord on 29.07.2017.
 */
public interface StudentRepository extends JpaRepository<Student, Long>{
    Student findByName(@Param("name") String name);
}
