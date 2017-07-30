package com.spbgti.dispatcherapp.service.impl;

import com.spbgti.dispatcherapp.entity.Student;
import com.spbgti.dispatcherapp.repository.StudentRepository;
import com.spbgti.dispatcherapp.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Gilbord on 29.07.2017.
 */
public class StudentService implements ServiceInterface<Student> {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student add(Student entity) {
        return studentRepository.saveAndFlush(entity);
    }

    @Override
    public void delete(long id) {
        studentRepository.delete(id);
    }

    @Override
    public Student getByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Student edit(Student entity) {
        return studentRepository.saveAndFlush(entity);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}
