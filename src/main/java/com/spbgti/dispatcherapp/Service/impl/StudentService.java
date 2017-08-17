package com.spbgti.dispatcherapp.Service.impl;

import com.spbgti.dispatcherapp.Entity.Student;
import com.spbgti.dispatcherapp.Repository.StudentRepository;
import com.spbgti.dispatcherapp.Service.ServiceInterface;
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
    public Student add(Student s) {
        return students.saveAndFlush(s);
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
    public Student edit(Student s) {
        return students.saveAndFlush(s);
    }

    @Override
    public List<Student> getAll() {
        return students.findAll();
    }
}
