package com.spbgti.dispatcherapp.entity.Event;

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
    public String apply(){
        return "2";
    }
}
