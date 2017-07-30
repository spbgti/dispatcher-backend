package com.spbgti.dispatcherapp.service.impl;

import com.spbgti.dispatcherapp.entity.Candidate;
import com.spbgti.dispatcherapp.repository.SeniorRepository;
import com.spbgti.dispatcherapp.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Gilbord on 29.07.2017.
 */
@Service
public class SeniorService implements ServiceInterface<Candidate> {

    @Autowired
    private SeniorRepository seniorRepository;

    @Override
    public Candidate add(Candidate entity) {
        return seniorRepository.saveAndFlush(entity);
    }

    @Override
    public void delete(long id) {
        seniorRepository.delete(id);
    }

    @Override
    public Candidate getByName(String name) {
        return seniorRepository.findByName(name);
    }

    @Override
    public Candidate edit(Candidate entity) {
        return seniorRepository.saveAndFlush(entity);
    }

    @Override
    public List<Candidate> getAll() {
        return seniorRepository.findAll();
    }
}
