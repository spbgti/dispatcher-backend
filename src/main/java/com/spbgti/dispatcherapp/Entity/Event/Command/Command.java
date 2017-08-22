package com.spbgti.dispatcherapp.Entity.Event.Command;

import javax.persistence.EntityManager;
import java.lang.reflect.InvocationTargetException;

public interface Command {
    public Object apply(EntityManager entityManager) throws ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException;
}
