package com.spbgti.dispatcherapp.Entity.Event;

public class UpdateCommand<T> implements Command {
    private String Type;
    private int entityId;
    private String field;
    private T old;
    private T newT;

    public UpdateCommand() {
    }

    public UpdateCommand(String type, int entityId, String field, T old, T newT) {
        Type = type;
        this.entityId = entityId;
        this.field = field;
        this.old = old;
        this.newT = newT;
    }

    @Override
    public String apply() {
        return null;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public T getOld() {
        return old;
    }

    public void setOld(T old) {
        this.old = old;
    }

    public T getNewT() {
        return newT;
    }

    public void setNewT(T newT) {
        this.newT = newT;
    }
}
