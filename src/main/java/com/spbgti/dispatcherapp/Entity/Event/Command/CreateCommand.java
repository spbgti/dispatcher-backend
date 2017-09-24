package com.spbgti.dispatcherapp.Entity.Event.Command;

import com.spbgti.dispatcherapp.Repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;

public class CreateCommand implements Command {
    private String type;
    private Object entity;

    @Autowired
    EntityRepository entityRepository;

    public CreateCommand() {
    }

    public CreateCommand(String type, LinkedHashMap entity) {
        this.type = type;
        this.entity = entity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getEntity() {
        return entity;
    }

    public void setEntity(Object entity) {
        this.entity = entity;
    }

    @Override
    public Object apply() throws ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
        return this.entityRepository.create(this);
    }
}
