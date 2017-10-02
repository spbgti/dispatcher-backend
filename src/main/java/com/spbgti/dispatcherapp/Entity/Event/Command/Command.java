package com.spbgti.dispatcherapp.Entity.Event.Command;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.lang.reflect.InvocationTargetException;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public interface Command {
    public Object apply() throws ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException;
}
