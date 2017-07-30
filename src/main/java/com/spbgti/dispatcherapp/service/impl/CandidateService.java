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
public class CandidateService implements ServiceInterface<Candidate> {

    @Autowired
    private SeniorRepository candidates;

    @Override
    public Candidate add(Candidate entity) {
        return candidates.saveAndFlush(entity);
    }

    @Override
    public void delete(long id) {
        candidates.delete(id);
    }

    @Override
    public Candidate getByName(String name) {
        return candidates.findByName(name);
    }

    @Override
    public Candidate edit(Candidate entity) {
        return candidates.saveAndFlush(entity);
    }

    @Override
    public List<Candidate> getAll() {
        return candidates.findAll();
    }
}
