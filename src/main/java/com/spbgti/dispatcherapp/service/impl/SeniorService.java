package com.spbgti.dispatcherapp.service.impl;

import com.spbgti.dispatcherapp.entity.Senior;
import com.spbgti.dispatcherapp.repository.SeniorRepository;
import com.spbgti.dispatcherapp.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Gilbord on 29.07.2017.
 */
public class SeniorService implements ServiceInterface<Senior> {

    @Autowired
    private SeniorRepository seniorRepository;

    @Override
    public Senior add(Senior entity) {
        return seniorRepository.saveAndFlush(entity);
    }

    @Override
    public void delete(long id) {
        seniorRepository.delete(id);
    }

    @Override
    public Senior getByName(String name) {
        return seniorRepository.findByName(name);
    }

    @Override
    public Senior edit(Senior entity) {
        return seniorRepository.saveAndFlush(entity);
    }

    @Override
    public List<Senior> getAll() {
        return seniorRepository.findAll();
    }
}
