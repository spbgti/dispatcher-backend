package com.spbgti.dispatcherapp.service.impl;

import com.spbgti.dispatcherapp.entity.Student;
import com.spbgti.dispatcherapp.repository.StudentRepository;
import com.spbgti.dispatcherapp.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Gilbord on 29.07.2017.
 */
@Service
public class StudentService implements ServiceInterface<Student> {
    @Autowired
    private StudentRepository students;

    @Override
    public Student add(Student entity) {
        return students.saveAndFlush(entity);
    }

    @Override
    public void delete(long id) {
        students.delete(id);
    }

    @Override
    public Student getByName(String name) {
        return students.findByName(name);
    }

    @Override
    public Student edit(Student entity) {
        return students.saveAndFlush(entity);
    }

    @Override
    public List<Student> getAll() {
        return students.findAll();
    }
}
