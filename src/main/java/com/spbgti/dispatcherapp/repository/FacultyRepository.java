package com.spbgti.dispatcherapp.repository;

import com.spbgti.dispatcherapp.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Faculty findByName(@Param("name") String name);
}
