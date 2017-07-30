package com.spbgti.dispatcherapp.repository;

import com.spbgti.dispatcherapp.entity.Chair;
import com.spbgti.dispatcherapp.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findByName(@Param("name") String name);
}
