package com.spbgti.dispatcherapp.Entity.Event;

import java.util.List;

public class FailedReadEvent extends ReadEvent {
    private String exception;

    public FailedReadEvent() {
    }

    public FailedReadEvent(User user, SessionInfo session, List<Query> queries, String exception) {
        super(user, session, queries);
        this.exception = exception;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
