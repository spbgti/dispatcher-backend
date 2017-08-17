package com.spbgti.dispatcherapp.Service.impl;

import com.spbgti.dispatcherapp.Entity.Speciality;
import com.spbgti.dispatcherapp.Repository.SpecialityRepository;
import com.spbgti.dispatcherapp.Service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SpecialityService implements ServiceInterface<Speciality> {

    @Autowired
    private SpecialityRepository specialityRepository;

    @Override
    public Speciality add(Speciality speciality) {
        return specialityRepository.saveAndFlush(speciality);
    }

    @Override
    public void delete(long id) {
        specialityRepository.delete(id);
    }

    @Override
    public Speciality getByName(String name) {
        return specialityRepository.findByName(name);
    }

    @Override
    public Speciality edit(Speciality speciality) {
        return specialityRepository.saveAndFlush(speciality);
    }

    @Override
    public List<Speciality> getAll() {
        return specialityRepository.findAll();
    }
}
