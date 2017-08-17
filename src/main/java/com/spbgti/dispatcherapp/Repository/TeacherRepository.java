package com.spbgti.dispatcherapp.Repository;

import com.spbgti.dispatcherapp.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findByName(@Param("name") String name);
}
