package com.spbgti.dispatcherapp.Entity.Event;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EntityManager;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "ModifyEvent")
public class ModifyEvent extends Event {
    private List<Command> commands;


    public ModifyEvent() {
    }

    public ModifyEvent(User user, SessionInfo session, String date, List<Command> commands) {
        super(user, session, date);
        this.commands = commands;
    }

    @Override
    public List<Object> apply(EntityManager entityManager) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        List<Object> list = new ArrayList<>();
        for (Command command : commands) {
            list.add(command.apply(entityManager));
        }
        return list;
    }
}
