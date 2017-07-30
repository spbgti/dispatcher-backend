package com.spbgti.dispatcherapp.service.impl;

import com.spbgti.dispatcherapp.entity.Group;
import com.spbgti.dispatcherapp.repository.GroupRepository;
import com.spbgti.dispatcherapp.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Gilbord on 29.07.2017.
 */
@Service
public class GroupService implements ServiceInterface<Group> {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Group add(Group entity) {
        return groupRepository.saveAndFlush(entity);
    }

    @Override
    public void delete(long id) {
        groupRepository.delete(id);
    }

    @Override
    public Group getByName(String num) {
        return groupRepository.findByNumberOfGroup(num);
    }

    @Override
    public Group edit(Group entity) {
        return groupRepository.saveAndFlush(entity);
    }

    @Override
    public List<Group> getAll() {
        return groupRepository.findAll();
    }
}
