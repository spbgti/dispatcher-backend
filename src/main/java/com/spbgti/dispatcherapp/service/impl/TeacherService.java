package com.spbgti.dispatcherapp.service.impl;

import com.spbgti.dispatcherapp.entity.Teacher;
import com.spbgti.dispatcherapp.entity.Teacher;
import com.spbgti.dispatcherapp.repository.TeacherRepository;
import com.spbgti.dispatcherapp.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherService implements ServiceInterface<Teacher> {

    @Autowired
    private TeacherRepository teachers;

    @Override
    public Teacher add(Teacher entity) {
        return teachers.saveAndFlush(entity);
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
    public Teacher edit(Teacher entity) {
        return teachers.saveAndFlush(entity);
    }

    @Override
    public List<Teacher> getAll() {
        return teachers.findAll();
    }
}
