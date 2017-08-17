package com.spbgti.dispatcherapp.entity.Event;


import java.util.LinkedHashMap;

public class CreateCommand implements Command {
    private String type;
    private LinkedHashMap entity;

    public CreateCommand() {
    }

    public CreateCommand(String type, LinkedHashMap entity) {
        this.type = type;
        this.entity = entity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LinkedHashMap getEntity() {
        return entity;
    }

    public void setEntity(LinkedHashMap entity) {
        this.entity = entity;
    }

    @Override
    public String apply() {
        return null;
    }
}
