package com.spbgti.dispatcherapp.entity.Event;

import javax.persistence.Entity;

public class Event {
    private User user;
    private SessionInfo session;


    public Event() {
    }

    public Event(User user, SessionInfo session) {
        this.user = user;
        this.session = session;
    }

    public String apply(){
        return "1";
    }

    public User getUser() {
        return user;
    }

    public SessionInfo getSession() {
        return session;
    }
}
