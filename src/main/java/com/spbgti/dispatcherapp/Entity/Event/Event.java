package com.spbgti.dispatcherapp.Entity.Event;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Document(collection = "Event")
public abstract class Event {
    @Id
    private String id;
    private String date;
    private User user;
    private SessionInfo session;

    public Event() {
    }

    public Event(User user, SessionInfo session, String date) {
        this.user = user;
        this.session = session;
        this.date = date;
    }

    public abstract List<Object> apply() throws ClassNotFoundException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException;

    public User getUser() {
        return user;
    }

    public SessionInfo getSession() {
        return session;
    }

    public String getDate() {
        return date;
    }
}
