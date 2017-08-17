package com.spbgti.dispatcherapp.Service.impl;

import com.spbgti.dispatcherapp.Entity.Teacher;
import com.spbgti.dispatcherapp.Repository.TeacherRepository;
import com.spbgti.dispatcherapp.Service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherService implements ServiceInterface<Teacher> {

    @Autowired
    private TeacherRepository teachers;

    @Override
    public Teacher add(Teacher t) {
        return teachers.saveAndFlush(t);
    }

    @Override
    public void delete(long id) {
        teachers.delete(id);
    }

    @Override
    public Teacher getByName(String name) {
        return teachers.findByName(name);
    }

    @Override
    public Teacher edit(Teacher t) {
        return teachers.saveAndFlush(t);
    }

    @Override
    public List<Teacher> getAll() {
        return teachers.findAll();
    }
}
