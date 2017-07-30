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
    public Candidate add(Candidate c) {
        return candidates.saveAndFlush(c);
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
    public Candidate edit(Candidate c) {
        return candidates.saveAndFlush(c);
    }

    @Override
    public List<Candidate> getAll() {
        return candidates.findAll();
    }
}
