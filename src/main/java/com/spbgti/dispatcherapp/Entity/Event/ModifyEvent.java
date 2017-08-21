package com.spbgti.dispatcherapp.Entity.Event;

import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Document(collection = "ModifyEvent")
public class ModifyEvent extends Event {
    private List<Command> commands;


    public ModifyEvent() {
    }

    public ModifyEvent(User user, SessionInfo session, List<Command> commands) {
        super(user, session);
        this.commands = commands;
    }

    @Override
    public List<Object> apply(EntityManager entityManager) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        List<Object> list = new ArrayList<>();
        for(Command command : commands){
                list.add(command.apply(entityManager));
        }
        return list;
    }
}
