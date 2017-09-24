package com.spbgti.dispatcherapp.Entity.Event.Command;

import com.spbgti.dispatcherapp.Entity.Event.ClassParser;
import com.spbgti.dispatcherapp.Repository.EntityRepository;
import com.spbgti.dispatcherapp.Service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.lang.reflect.InvocationTargetException;
@Component
public class DeleteCommand implements Command {

    private String type;
    private int entityId;

    @Autowired
    EntityRepository entityRepository;

    public DeleteCommand() {
    }

    public DeleteCommand(String type, int entityId) {
        this.type = type;
        this.entityId = entityId;
    }

    @Override
    public Object apply() throws ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
        return entityRepository.delete(this);
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
