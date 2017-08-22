package com.spbgti.dispatcherapp.Entity.Event.Command;

import com.spbgti.dispatcherapp.Entity.Event.ClassParser;

import javax.persistence.EntityManager;
import java.lang.reflect.InvocationTargetException;

public class DeleteCommand implements Command {
    private String type;

    private int entityId;

    public DeleteCommand() {
    }

    public DeleteCommand(String type, int entityId) {
        this.type = type;
        this.entityId = entityId;
    }

    @Override
    public Object apply(EntityManager entityManager) throws ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
        new ClassParser().getClassFor(this.type);
        String sqlQuery = "DELETE "
                + new ClassParser().firstCharToUpperCase(type)
                + " WHERE id = :idValue";
        entityManager.createQuery(sqlQuery).setParameter("idValue", (long) this.entityId).executeUpdate();
        return new Object();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }
}