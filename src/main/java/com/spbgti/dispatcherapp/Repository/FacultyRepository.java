package com.spbgti.dispatcherapp.Repository;

import com.spbgti.dispatcherapp.Entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Faculty findByName(@Param("name") String name);
}
