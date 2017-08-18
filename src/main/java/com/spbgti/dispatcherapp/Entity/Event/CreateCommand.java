package com.spbgti.dispatcherapp.Entity.Event;


import javax.persistence.EntityManager;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;

public class CreateCommand implements Command {
    private String type;
    private LinkedHashMap entity;

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

    public LinkedHashMap getEntity() {
        return entity;
    }

    public void setEntity(LinkedHashMap entity) {
        this.entity = entity;
    }

    @Override
    public Object apply(EntityManager entityManager) throws ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
        Object object = new LinkedHashMapParser().parse(this);
        entityManager.persist(object);
        return object;
    }
}
