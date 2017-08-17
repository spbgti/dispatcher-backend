package com.spbgti.dispatcherapp.entity.Event;

public class DeleteCommand implements Command {
    private String type;
    private int entityId;

    public DeleteCommand() {
    }

    public DeleteCommand(String type, int entityId) {
        this.type = type;
        this.entityId = entityId;
    }

    @Override
    public String apply() {
        return null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }
}
