package com.spbgti.dispatcherapp.Service.impl;

import com.spbgti.dispatcherapp.Entity.Faculty;
import com.spbgti.dispatcherapp.Repository.FacultyRepository;
import com.spbgti.dispatcherapp.Service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Man on 31.07.2017.
 */
@Service
public class FacultyService implements ServiceInterface<Faculty> {

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public Faculty add(Faculty faculty) {
        return facultyRepository.saveAndFlush(faculty);
    }

    @Override
    public void delete(long id) {
        facultyRepository.delete(id);
    }

    @Override
    public Faculty getByName(String name) {
        return facultyRepository.findByName(name);
    }

    @Override
    public Faculty edit(Faculty faculty) {
        return facultyRepository.saveAndFlush(faculty);
    }

    @Override
    public List<Faculty> getAll() {
        return facultyRepository.findAll();
    }
}
