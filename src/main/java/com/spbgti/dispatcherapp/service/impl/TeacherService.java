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
    private TeacherRepository teacherRepository;

    @Override
    public Teacher add(Teacher entity) {
        return teacherRepository.saveAndFlush(entity);
    }

    @Override
    public void delete(long id) {
        teacherRepository.delete(id);
    }

    @Override
    public Teacher getByName(String name) {
        return teacherRepository.findByName(name);
    }

    @Override
    public Teacher edit(Teacher chair) {
        return teacherRepository.saveAndFlush(chair);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }
}
