package com.spbgti.dispatcherapp.service.impl;

import com.spbgti.dispatcherapp.entity.Chair;
import com.spbgti.dispatcherapp.repository.ChairRepository;
import com.spbgti.dispatcherapp.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChairService implements ServiceInterface<Chair> {

    @Autowired
    private ChairRepository chairs;

    @Override
    public Chair add(Chair entity) {
        return chairs.saveAndFlush(entity);
    }

    @Override
    public void delete(long id) {
        chairs.delete(id);
    }

    @Override
    public Chair getByName(String name) {
        return chairs.findByName(name);
    }

    @Override
    public Chair edit(Chair entity) {
       return chairs.saveAndFlush(entity);
    }

    @Override
    public List<Chair> getAll() {
        return chairs.findAll();
    }
}
