package com.spbgti.dispatcherapp.Repository;

import com.spbgti.dispatcherapp.Entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Gilbord on 29.07.2017.
 */
public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByName(@Param("num") String num);
}