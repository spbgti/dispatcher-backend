package com.spbgti.dispatcherapp.Entity.Event;

import javax.persistence.EntityManager;
import java.util.List;

public class Event {
    private User user;
    private SessionInfo session;


    public Event() {
    }

    public Event(User user, SessionInfo session) {
        this.user = user;
        this.session = session;
    }

    public List<Object> apply(EntityManager entityManager){
        return null;
    }

    public User getUser() {
        return user;
    }

    public SessionInfo getSession() {
        return session;
    }
}
