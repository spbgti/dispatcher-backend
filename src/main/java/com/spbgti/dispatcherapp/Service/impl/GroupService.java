package com.spbgti.dispatcherapp.Service.impl;

import com.spbgti.dispatcherapp.Entity.Group;
import com.spbgti.dispatcherapp.Repository.GroupRepository;
import com.spbgti.dispatcherapp.Service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Gilbord on 29.07.2017.
 */
@Service
public class GroupService implements ServiceInterface<Group> {

    @Autowired
    private GroupRepository groups;

    @Override
    public Group add(Group g) {
        return groups.saveAndFlush(g);
    }

    @Override
    public void delete(long id) {
        groups.delete(id);
    }

    @Override
    public Group getByName(String name) {
        return groups.findByName(name);
    }

    @Override
    public Group edit(Group g) {
        return groups.saveAndFlush(g);
    }

    @Override
    public List<Group> getAll() {
        return groups.findAll();
    }
}
