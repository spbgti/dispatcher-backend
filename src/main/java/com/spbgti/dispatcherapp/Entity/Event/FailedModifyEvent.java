package com.spbgti.dispatcherapp.Entity.Event;

import java.util.List;

public class FailedModifyEvent extends ModifyEvent {
    private String exception;

    public FailedModifyEvent() {
    }

    public FailedModifyEvent(User user, SessionInfo session, String date, List<Command> commands, String exception) {
        super(user, session, date, commands);
        this.exception = exception;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
