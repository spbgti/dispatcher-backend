package com.spbgti.dispatcherapp.Entity.Event.Command;

import javax.persistence.EntityManager;
import java.lang.reflect.InvocationTargetException;

public interface Command {
    public Object apply() throws ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException;
}
