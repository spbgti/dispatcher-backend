package com.spbgti.dispatcherapp.Entity.Event;

import javax.persistence.EntityManager;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ModifyEvent extends Event {
    private List<Command> commands;

    public ModifyEvent() {
    }

    public ModifyEvent(User user, SessionInfo session, List<Command> commands) {
        super(user, session);
        this.commands = commands;
    }

    @Override
    public List<Object> apply(EntityManager entityManager){
        List<Object> list = new ArrayList<>();
        for(Command command : commands){
            try {
               list.add(command.apply(entityManager));
            } catch (ClassNotFoundException
                    | NoSuchMethodException
                    | InstantiationException
                    | InvocationTargetException
                    | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
