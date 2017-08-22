package com.spbgti.dispatcherapp.Entity.Event.Command;

import com.spbgti.dispatcherapp.Entity.Event.ClassParser;

import javax.persistence.EntityManager;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;

public class CreateCommand implements Command {
    private String type;
    private Object entity;

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
    public Object apply(EntityManager entityManager) throws ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
        Object object = new ClassParser().parse((LinkedHashMap) this.entity, this.type);
        entityManager.persist(object);
        return object;
    }
}